package swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingFile2  extends JFrame implements  ActionListener{
	private JTextField tf;
	private JTextArea ta;
	private JButton readBtn, writeBtn;
	
	public SwingFile2() {
		super("SwingFile2");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 readBtn = new JButton("읽기 ");
		 writeBtn = new JButton("쓰기");
		 tf = new JTextField(20);
		 ta = new JTextArea(20, 40);
		 tf.setEditable(false);
		 
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
         JButton btn =(JButton) e.getSource();
         if(btn==readBtn) {
        	 JFileChooser fc = new JFileChooser();
        //	int i = fc.showOpenDialog(SwingFile2.this);
        //	if(i==1) return;
        	 if( fc.showOpenDialog(SwingFile2.this)==JFileChooser.CANCEL_OPTION)
              return;
        	 
        	File f =  fc.getSelectedFile();
        	tf.setText(f.getName());
        	try {
//				Scanner sc = new Scanner(f);
//				while(sc.hasNext()) {
//					ta.append(sc.nextLine()+"\n");
//				}
//				sc.close();
        		FileReader fr = new FileReader(f);
        		int i;
        		while((i = fr.read())!=-1) {
        			ta.append((char)i+"");
        		}
               fr.close();
			} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
         }else { //¾²±â
          	 JFileChooser fc = new JFileChooser();
          	 if(fc.showSaveDialog(SwingFile2.this) == JFileChooser.CANCEL_OPTION)
          		return;
          	 File f = fc.getSelectedFile();
          	 tf.setText(f.getName());
          	 try {
				FileWriter fw = new FileWriter(f);
				fw.write(ta.getText());
				fw.close();
			} catch (IOException e1) {
					e1.printStackTrace();
			}
          	 
         }
	}

	public static void main(String[] args) {
         new SwingFile2();

	}


}