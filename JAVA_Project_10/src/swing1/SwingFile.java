package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingFile  extends JFrame implements  ActionListener{
	private JTextField tf;
	private JTextArea ta;
	public SwingFile() {
		super("SwingFile");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton readBtn = new JButton("읽기");
		JButton writeBtn = new JButton("쓰기");
		 tf = new JTextField(20);
		 ta = new JTextArea(20, 40);
		JScrollPane jsp = new JScrollPane(ta);
		add(tf);
		add(readBtn);
		add(writeBtn);
		add(jsp);
		readBtn.addActionListener(this);
		writeBtn.addActionListener(this);
			
		setSize(500, 500);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("읽기")) {
			try {
				Scanner sc = new Scanner(new File(tf.getText()));
				while(sc.hasNext()) {
					ta.append(sc.nextLine()+"\n");
				}
				
			} catch (FileNotFoundException e1) {
					new MessageBox("파일오류","파일이 없습니다");
			}
		}else {  //쓰기
		     try {
				FileWriter fw = new FileWriter(tf.getText());
				fw.write(ta.getText());
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
         new SwingFile();

	}



}
