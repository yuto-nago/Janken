package sample;

import java.util.ArrayList;

public class Computer{

	//コンピューターのグー
	private int rock_cp;

	//コンピューターのパー
	private int paper_cp;

	//コンピューターのチョキ
	private int scissors_cp;

	//プレイヤーのグーを数える変数
    private double rock_count;

    //プレイヤーのパーを数える変数
	private double paper_count;

	//プレイヤーのチョキを数える変数
	private double scissors_count;

	//配列の要素数
	private int count;

	//人間の出した手を保存しておく配列
	//private int[] data = new int[1000];

	//人間の出した手を保存しておくリスト
	private ArrayList<Integer> list = new ArrayList<Integer>();


	/**
	 * コンストラクタ
	 * @param rock_cp
	 * @param paper_cp
	 * @param scissors_cp
	 */
	public Computer(int rock_cp, int paper_cp, int scissors_cp){
		this.rock_cp = rock_cp;
		this.paper_cp = paper_cp;
		this.scissors_cp = scissors_cp;
	}

	/**
	 * ゲッターメソッド
	 * @return cpのグーの値
	 */
	public int getRock_cp() {
		return rock_cp;
	}

	/**
	 * セッターメソッド
	 * @param rock_cp
	 */
	public void setRock_cp(int rock_cp) {
		this.rock_cp = rock_cp;
	}

	/**
	 * ゲッターメソッド
	 * @return cpのパーの値
	 */
	public int getPaper_cp() {
		return paper_cp;
	}

	/**
	 * セッターメソッド
	 * @param paper_cp
	 */
	public void setPaper_cp(int paper_cp) {
		this.paper_cp = paper_cp;
	}

	/**
	 * ゲッターメソッド
	 * @return cpのチョキの値
	 */
	public int getScissors_cp() {
		return scissors_cp;
	}

	/**
	 * セッターメソッド
	 * @param scissors_cp
	 */
	public void setScissors_cp(int scissors_cp) {
		this.scissors_cp = scissors_cp;
	}

	/**
	 * ゲッターメソッド
	 * @return int型配列 data
	 */
	//public int[] getData() {
	//	return data;
	//}

	/**
	 * セッターメソッド
	 * @param data
	 */
	//public void setData(int[] data) {
	//	this.data = data;
	//}


	/**
	 * ゲッターメソッド
	 * @return Integer型のリスト
	 */
	public ArrayList<Integer> getList() {
		return list;
	}

	/**
	 * cpが出すじゃんけんの手
	 * @return cpの手
	 */
	public int pc_turn(){

		//割合を代入する変数
		int rock, paper, scissors, random;

		//配列の中身を調べる
		for(int i = 0; i < list.size(); i++){

			if(list.get(i) == 1){
				rock_count++;
				count++;
			}else if(list.get(i) == 2){
				paper_count++;
				count++;
			}else if(list.get(i) == 3){
				scissors_count++;
				count++;
			}else{
				break;
			}

		}

		//グーの割合
		rock = (int)Math.round((rock_count / count) * 100);

		//パーの割合
		paper = (int)Math.round((paper_count / count) * 100);

		//チョキの割合
		scissors = (int)Math.round((scissors_count / count) * 100);

		//一番多い割合の手を返す
		if((rock < paper) && (scissors < paper)){
			rock_count = 0;
			paper_count = 0;
			scissors_count = 0;
			return 3;
		}else if((paper < rock) && (scissors < rock)){
			rock_count = 0;
			paper_count = 0;
			scissors_count = 0;
			return 2;
		}else if((paper < scissors) && (rock < scissors)){
			rock_count = 0;
			paper_count = 0;
			scissors_count = 0;
			return 1;
		}else{
			random = (int)(Math.random() * 3) + 1;
		}

		rock_count = 0;
		paper_count = 0;
		scissors_count = 0;
		return random;





	}



}
