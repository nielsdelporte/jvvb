package com.sorcix.jvvb;

import org.json.JSONObject;
import java.util.Date;

public class Match {

	public class Sub {

		private Score score;
		private Score[] sets;
		private boolean forfaitHome;
		private boolean forfaitVisitors;

		public Score getScore() {
			return this.score;
		}

		public void setScore(Score score) {
			this.score = score;
		}

		public Score[] getSets() {
			return this.sets;
		}

		public void setSets(Score[] sets) {
			this.sets = sets;
		}

		public boolean IsForfaitHome() {
			return this.forfaitHome;
		}

		public boolean SetForfaitHome(boolean forfait) {
			this.forfaitHome = forfait;
		}

		public boolean IsForfaitVisitors() {
			return this.forfaitVisitors;
		}

		public boolean SetForfaitVisitors(boolean forfait) {
			this.forfaitVisitors = forfait;
		}
	}

	public class Score {
		
		private int home;
		private int visitors;

		public Score() {}

		public Score(int home, int visitors) {
			this.home = home;
			this.visitors = visitors;
		}

		public int getHome() {
			return this.home;
		}

		public void setHome(int home) {
			this.home = home;
		}

		public void setHome(String home) {
			this.home = Integer.parseInt(home);
		}

		public int getVisitors() {
			return this.visitors;
		}

		public void setVisitors() {
			this.visitors = visitors;
		}

		public void setVisitors(String visitors) {
			this.visitors = Integer.parseInt(visitors);
		}
	}

	private BaseTeam home;
	private BaseTeam visitors;

	private Sub main;
	private Sub reserve;

	public Match(JSONObject json) {

		// Save team details
		this.home = new BaseTeam(json.getString("match_home_team_id"),json.getString("team_home"));
		this.visitors = new BaseTeam(json.getString("match_visitor_team_id"),json.getString("team_visitors"));

		// Save match scores
		this.main = this.extractSub(false, json);
		this.reserve = this.extractSub(true, json);
	}

	private void extractSub(boolean reserve, JSONObject json) {

		Sub sub = this.new Sub();

		// Set prefix for reserve matches
		String prefix = reserve ? "match_reserve_" : "match_";

		// Forfait
		sub.forfaitHome = json.getString(prefix+"home_forfait") != "0";
		sub.forfaitVisitors = json.getString(prefix+"visitors_forfait") != "0";

		// Update prefix for scores
		prefix = reserve ? "match_reserve_score_" : "match_score_";

		sub.score = this.new Score();
		sub.score.setHome(json.getString(prefix+"home"));
		sub.score.setVisitors(json.getString(prefix+"visitors"));

		// Determine the number of sets played.
		int max = sub.score.home;
		if(max < sub.score.visitors) {
			max = sub.score.visitors;
		}

		// Extract the set scores from given JSON object.
		Score[] sets = new Score[max];
		for(int i=0;i<max;i++) {
			sets[i] = new Score();
			sets[i].setHome(json.getString(prefix+"home_set"+(i+1)));
			sets[i].setVisitors(json.getString(prefix+"visitors_set"+(i+1)));
		}

		return sets;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(!(other instanceof Match)) {
			return false;
		}
		if(this.number.equals(((Match)other).number)) {
			return true;
		}
		return false;
	}
}
