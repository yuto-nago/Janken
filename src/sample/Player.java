package sample;

public class Player {

	//グー
	private int rock;

	//チョキ
	private int paper;

	//パー
	private int scissors;

	/**
	 * コンストラクタ
	 * @param rock グーの値
	 * @param paper パーの値
	 * @param scissors チョキの値
	 */
	public Player(int rock, int paper, int scissors){
		this.rock = rock;
		this.paper = paper;
		this.scissors = scissors;
	}

	/**
	 * ゲッターメソッド
	 * @return グーの値
	 */
	public int getRock() {
		return rock;
	}

	/**
	 * セッターメソッド
	 * @param rock
	 */
	public void setRock(int rock) {
		this.rock = rock;
	}

	/**
	 * ゲッターメソッド
	 * @return パーの値
	 */
	public int getPaper() {
		return paper;
	}

	/**
	 * セッターメソッド
	 * @param paper
	 */
	public void setPaper(int paper) {
		this.paper = paper;
	}

	/**
	 * ゲッターメソッド
	 * @return チョキの値
	 */
	public int getScissors() {
		return scissors;
	}

	/**
	 * セッターメソッド
	 * @param scissors
	 */
	public void setScissors(int scissors) {
		this.scissors = scissors;
	}






}
