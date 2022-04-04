package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//내부클래스 이용
public class JGugudan2  extends JFrame  {
	private JTextField tf;
	private JTextArea ta;
	public JGugudan2() {
		setTitle("내부클래스_구구단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		 tf = new JTextField(10);
		JButton btn = new JButton("실행");
		 ta = new JTextArea(10,15);
		 JScrollPane jsp = new JScrollPane(ta);
		
		add(tf);
		add(btn);
		add(jsp);
		InnerGugu2 ig = new InnerGugu2();
		btn.addActionListener(ig);
		tf.addActionListener(ig);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JGugudan2();

	}
   class InnerGugu2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		int d =Integer.parseInt(tf.getText());  //String ->int
		
		for(int i = 1; i<10;i++) {
				ta.append(d+"*"+i+"="+d*i+"\n");
		}
		
	}
	   
   }

}



