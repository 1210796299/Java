package com.game.entity;

public class game {
	private int id;
	/** 游戏名称 */
	private String gameName;
	/** 游戏名称 */
	private String gameType;
	/** 发行公司 */
	private String gameCompany;
	/** 发行时间 */
	private int gameYear;

	public game() {
		super();
	}

	public String toString() {
		return "id：" + id + ", 游戏名称：" + gameName + ", 游戏名称：" + gameType + ", 发行公司：" + gameCompany + ", 发行时间："
				+ gameYear;
	}

	public game(int id, String gameName, String gameType, String gameCompany, int gameYear) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.gameType = gameType;
		this.gameCompany = gameCompany;
		this.gameYear = gameYear;
	}

	public game(String gameName, String gameType, String gameCompany, int gameYear) {
		super();
		this.gameName = gameName;
		this.gameType = gameType;
		this.gameCompany = gameCompany;
		this.gameYear = gameYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameCompany() {
		return gameCompany;
	}

	public void setGameCompany(String gameCompany) {
		this.gameCompany = gameCompany;
	}

	public int getGameYear() {
		return gameYear;
	}

	public void setGameYear(int gameYear) {
		this.gameYear = gameYear;
	}

}
