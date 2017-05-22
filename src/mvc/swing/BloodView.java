package mvc.swing;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.model.BloodAdviser;

public class BloodView extends JFrame{
	Choice ch;
	JButton bt;
	
	public BloodView() {
		setLayout(new FlowLayout());
		ch = new Choice();
		ch.add("A");
		ch.add("B");
		ch.add("AB");
		ch.add("O");
		bt = new JButton("����");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getResult();				
			}
		});
		
		add(ch);
		add(bt);
		
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void getResult(){
		//1~2�ܰ�: ��û�� �ް� �м��Ѵ�
		String blood = ch.getSelectedItem();
		
		//3�ܰ�: �˸´� ���� ��ü�� �� ��Ų��.
		BloodAdviser adviser = new BloodAdviser();
		String msg = adviser.getAdvice(blood);
		
		//4�ܰ� ����: ���⼭ �����ٲ���
		//5�ܰ�: ����� �����ش�.
		
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new BloodView();
	}
	
}
