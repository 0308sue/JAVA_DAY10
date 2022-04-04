package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//this 이용
public class JGugudan  extends JFrame  implements ActionListener{
	private JTextField tf;
	private JTextArea ta;
	public JGugudan() {
		setTitle("구구단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		 tf = new JTextField(10);
		JButton btn = new JButton("실행");
		 ta = new JTextArea(10,15);
		 JScrollPane jsp = new JScrollPane(ta);
		
		add(tf);
		add(btn);
		add(jsp);
		btn.addActionListener(this);
		tf.addActionListener(this);
		
		setSize(300, 300);
		setVisible(true);
	}
 
	public static void main(String[] args) {
		new JGugudan();
 
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. tf  값을 가져와서
		//2. 구구단을 ta  출력
		ta.setText("");
		int d =Integer.parseInt(tf.getText());  //String ->int
		
		for(int i = 1; i<10;i++) {
				ta.append(d+"*"+i+"="+d*i+"\n");
		}
	
	}
 
}
