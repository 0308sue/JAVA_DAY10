package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//클래스 이용
public class JGugudan3  extends JFrame  {
	private JTextField tf;
	private JTextArea ta;
	public JGugudan3() {
		setTitle("클래스_구구단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		 tf = new JTextField(10);
		JButton btn = new JButton("실행");
		 ta = new JTextArea(10,15);
		 JScrollPane jsp = new JScrollPane(ta);
		
		add(tf);
		add(btn);
		add(jsp);
		InnerGugu3 ig3= new InnerGugu3(tf, ta);
		btn.addActionListener(ig3);
		tf.addActionListener(ig3);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JGugudan3();
	}

}//class JGugudan3

class InnerGugu3  implements ActionListener{
	private JTextArea ta;
	private JTextField tf;
	//생성자
	public InnerGugu3(JTextField tf, JTextArea ta) {
		this.tf = tf;
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		int d =Integer.parseInt(tf.getText());  //String ->int
		
		for(int i = 1; i<10;i++) {
				ta.append(d+"*"+i+"="+d*i+"\n");
		}
		
	}
	
}


