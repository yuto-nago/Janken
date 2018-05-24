package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import sample2.Util;

public class GamePlay {

	//プレイヤークラス
	private Player player;

	//コンピュータークラス
	private Computer computer = new Computer(1, 2, 3);

	//PrintWriter型変数の宣言
	private PrintWriter p;

	/**
	 * 最初にファイルからプレイヤーの手を読み込む
	 */
	{
		try (BufferedReader br = new BufferedReader(new FileReader("janken.txt"))) {
			String s;
			//数字を全て読み込む
			while((s = br.readLine()) != null){
				computer.getList().add(Integer.parseInt(s));
			}
		}catch(FileNotFoundException e){
			System.err.println("ファイルを開けない");
		}catch(IOException e){
			System.err.println("データを読み出せない");
		}
	}

	/**
	 * ゲーム実行メソッド
	 */
	public void play(){

		//Playerクラスのインスタンスを作成
		player = new Player(1, 2, 3);

		//Computerクラスのインスタンスを作成
		//computer = new Computer(1, 2, 3);

		//プレイヤーのじゃんけんの手
		int player_turn;

		//コンピューターのじゃんけんの手
		int cp_turn;

		//プレイヤーの勝利した回数
		int player_win = 0;

		//コンピューターの勝利した回数
		int cp_win = 0;

		//配列の要素数分じゃんけんをする
		for(int i = 0; i < 100; i++){

			System.out.println(i + 1 + "回目");

			//コンソールから値を入力
			player_turn = Util.input();

			//1,2,3でなければ入力に戻る
			if(player_turn <= 0 || player_turn > 4){
				System.out.println("1,2,3,のどれかで入力してください");
				i--;
				continue;
			}


			//プレイヤーの手を配列に保存
			computer.getList().add(player_turn);

			//コンピューターの手
			cp_turn = computer.pc_turn();

			//勝敗条件
			if(player_turn == player.getRock()){
				if(cp_turn == computer.getPaper_cp()){
					cp_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("コンピューターの勝ち");
				}else if(cp_turn == computer.getScissors_cp()){
					player_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("プレイヤーの勝ち");
				}else{
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("引き分け");
				}
			}else if(player_turn == player.getPaper()){
				if(cp_turn == computer.getScissors_cp()){
					cp_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("コンピューターの勝ち");
				}else if(cp_turn == computer.getRock_cp()){
					player_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("プレイヤーの勝ち");
				}else{
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("引き分け");
				}
			}else if(player_turn == player.getScissors()){
				if(cp_turn == computer.getRock_cp()){
					cp_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("コンピューターの勝ち");
				}else if(cp_turn == computer.getPaper_cp()){
					player_win++;
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("プレイヤーの勝ち");
				}else{
					System.out.println("コンピューターの手" + cp_turn);
					System.out.println("引き分け");
				}
			}

		}

		System.out.println("プレイヤー勝った回数" + player_win);
		System.out.println("コンピューター勝った回数" + cp_win);

		//ファイルにプレイヤーの手を書き出す
		try{

			p = new PrintWriter(new BufferedWriter(new FileWriter("janken.txt", true)));
			for(int i = 0; i < computer.getList().size(); i++){
				p.println(computer.getList().get(i));
			}
			p.close();

		}catch(IOException e){
			System.err.println("ファイルを作成できない");
		}



	}







}
