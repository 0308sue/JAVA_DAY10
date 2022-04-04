package swing1;

 
import java.awt.FlowLayout;
import java.awt.Font;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class ThreadTimer  extends JFrame{
  private JLabel timerLabel;
	public ThreadTimer() {
		setTitle("TIMER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		 timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC,80) );
	    add(timerLabel);
		new ThreadTime().start(); //run() 실행		
		setSize(300, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ThreadTimer();
	}
	//내부클래스
	class ThreadTime extends Thread {
		@Override
		public void run() {
			int n=0;
			while(true) {
				timerLabel.setText(Integer.toString(n));  // int->String
				n++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
