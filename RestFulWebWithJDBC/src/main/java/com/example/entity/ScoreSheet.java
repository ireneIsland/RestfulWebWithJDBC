package com.example.entity;

public class ScoreSheet {

	public int id;
	public String name;
	public String info;
	public double score;

	public ScoreSheet() {

	}

	public ScoreSheet(int id, String name, String info, double score) {

		this.id = id;
		this.name = name;
		this.info = info;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
