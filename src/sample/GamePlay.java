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

	//�v���C���[�N���X
	private Player player;

	//�R���s���[�^�[�N���X
	private Computer computer = new Computer(1, 2, 3);

	//PrintWriter�^�ϐ��̐錾
	private PrintWriter p;

	/**
	 * �ŏ��Ƀt�@�C������v���C���[�̎��ǂݍ���
	 */
	{
		try (BufferedReader br = new BufferedReader(new FileReader("janken.txt"))) {
			String s;
			//������S�ēǂݍ���
			while((s = br.readLine()) != null){
				computer.getList().add(Integer.parseInt(s));
			}
		}catch(FileNotFoundException e){
			System.err.println("�t�@�C�����J���Ȃ�");
		}catch(IOException e){
			System.err.println("�f�[�^��ǂݏo���Ȃ�");
		}
	}

	/**
	 * �Q�[�����s���\�b�h
	 */
	public void play(){

		//Player�N���X�̃C���X�^���X���쐬
		player = new Player(1, 2, 3);

		//Computer�N���X�̃C���X�^���X���쐬
		//computer = new Computer(1, 2, 3);

		//�v���C���[�̂���񂯂�̎�
		int player_turn;

		//�R���s���[�^�[�̂���񂯂�̎�
		int cp_turn;

		//�v���C���[�̏���������
		int player_win = 0;

		//�R���s���[�^�[�̏���������
		int cp_win = 0;

		//�z��̗v�f��������񂯂������
		for(int i = 0; i < 100; i++){

			System.out.println(i + 1 + "���");

			//�R���\�[������l�����
			player_turn = Util.input();

			//1,2,3�łȂ���Γ��͂ɖ߂�
			if(player_turn <= 0 || player_turn > 4){
				System.out.println("1,2,3,�̂ǂꂩ�œ��͂��Ă�������");
				i--;
				continue;
			}


			//�v���C���[�̎��z��ɕۑ�
			computer.getList().add(player_turn);

			//�R���s���[�^�[�̎�
			cp_turn = computer.pc_turn();

			//���s����
			if(player_turn == player.getRock()){
				if(cp_turn == computer.getPaper_cp()){
					cp_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�R���s���[�^�[�̏���");
				}else if(cp_turn == computer.getScissors_cp()){
					player_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�v���C���[�̏���");
				}else{
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("��������");
				}
			}else if(player_turn == player.getPaper()){
				if(cp_turn == computer.getScissors_cp()){
					cp_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�R���s���[�^�[�̏���");
				}else if(cp_turn == computer.getRock_cp()){
					player_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�v���C���[�̏���");
				}else{
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("��������");
				}
			}else if(player_turn == player.getScissors()){
				if(cp_turn == computer.getRock_cp()){
					cp_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�R���s���[�^�[�̏���");
				}else if(cp_turn == computer.getPaper_cp()){
					player_win++;
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("�v���C���[�̏���");
				}else{
					System.out.println("�R���s���[�^�[�̎�" + cp_turn);
					System.out.println("��������");
				}
			}

		}

		System.out.println("�v���C���[��������" + player_win);
		System.out.println("�R���s���[�^�[��������" + cp_win);

		//�t�@�C���Ƀv���C���[�̎�������o��
		try{

			p = new PrintWriter(new BufferedWriter(new FileWriter("janken.txt", true)));
			for(int i = 0; i < computer.getList().size(); i++){
				p.println(computer.getList().get(i));
			}
			p.close();

		}catch(IOException e){
			System.err.println("�t�@�C�����쐬�ł��Ȃ�");
		}



	}







}
