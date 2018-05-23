package sample2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util {

	/**
	 * じゃんけんの手を入力するメソッド
	 * @return 入力された値
	 */
	public static int input(){
		int x;
		System.out.print("グー、1　パー、2　チョキ、3");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try{
                String buf = br.readLine();
                x = Integer.parseInt(buf);
        }catch(Exception e){
                x = 0;
        }
        return x;
	}



}
