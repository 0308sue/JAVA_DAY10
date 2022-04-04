package swing1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank  extends JFrame{ //JFrame 기본레이아웃 BorderLayout
	
	private HashMap<String,Integer> hm = new HashMap<String, Integer>();
	private List lst;
	
	public Bank() {
		setTitle("BANK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		//왼쪽화면
		JPanel p1 = new JPanel();//이름 있는 라인(1번째)
		p1.add(new JLabel("이름"));
	    JTextField tfName = new JTextField(15);
	    p1.add(tfName);
	    
	    JButton btn = new JButton("계좌생성"); //2번째 라인
	    
	    JPanel p3 = new JPanel(); // 3번째 라인(잔액 있는 부분)
	    p3.add(new JLabel("잔액"));
	    JTextField tfBalance = new JTextField(15);
	    tfBalance.setEditable(false);
	    p3.setBackground(Color.yellow);
	    p3.add(tfBalance);
	    
	    JPanel p4 = new JPanel();  //4번째 라인(입출금 금액 부분)
	    JTextField tfMoney = new JTextField(15); 
	    p4.add(tfMoney);
	    p4.add(new JLabel("원"));
	    
	    JPanel p5 =new JPanel();// 5번째 라인(입출금 버튼 부분)
	    JButton inputBtn = new JButton("입금");
	    JButton outBtn = new JButton("출금");
	    JButton fileBtn = new JButton("파일저장");
	    p5.add(inputBtn);
	    p5.add(outBtn);
	    p5.add(fileBtn);
	    
	    JPanel panel = new JPanel(); // 5개 패널을 묶을 왼쪽 패널(JPanel 기본레이아웃 FlowLayout)
	    panel.add(p1);
	    panel.add(btn);
	    panel.add(p3);
	    panel.add(p4);
	    panel.add(p5);
	    panel.setBackground(Color.YELLOW);
	    
	    //오른쪽 화면
	     lst = new List();
	    
	    //루트(JFrame) 왼쪽, 오른쪽 부착
	    add(panel);
	    add(lst);
	    //계좌생성 버튼 : 오른쪽  list 에 추가
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			  String name = tfName.getText().trim();
			  if(name.isEmpty()) return;
			  lst.add(name);
			  tfName.setText("");
			  hm.put(name,0);//맵에 추가
			}
		});
		//리스트를 클릭
		lst.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//이름, 잔액 넣기
				String name = lst.getSelectedItem().trim();
				tfName.setText(name);
				tfBalance.setText(hm.get(name)+"");//hm.get(name).toString()
			}
		});
		
		//입금버튼
		inputBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 *  1. 리스트에 선택한 계좌 잔액에
				 *  2. 입금한 금액을 더해서
				 *  3. 잔액을 수정하고 맵에 추가(수정)
				 */
				try {
						String name = lst.getSelectedItem().trim();
						int money =Integer.parseInt(tfMoney.getText()); //입금할 돈
						//잔액변경 = 잔액+ 입금할 돈
						int balance = hm.get(name)+money;
						tfBalance.setText(balance+"");  //잔액을 수정
						hm.put(name, balance);//맵에 추가(수정)
						tfMoney.setText("");
				}catch (NumberFormatException n) {
					new MessageBox("입금오류!!", "숫자를 입력하세요");
				}catch(NullPointerException nu) {
					new MessageBox("입금계좌오류!!!", "계좌를 선택하세요");
				}
			}
		});
		
		//출금버튼
		outBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 *  1. 리스트에 선택한 계좌 잔액에
				 *  2. 출금할 금액을 빼고
				 *  3. 잔액을 수정하고 맵에 추가(수정)
				 */
				try {
			
						String name = lst.getSelectedItem().trim();
						int money = Integer.parseInt(tfMoney.getText());// 출금할 돈
						//잔액변경 = 잔액- 출금할 돈
						int balance = hm.get(name) - money;
						if(balance < 0 ) {
						    new MessageBox("잔액부족!!",  name+" 님 잔액이 부족합니다.");
							tfMoney.setText("");
							return;
						}
						tfBalance.setText(balance+""); //잔액변경
						hm.put(name, balance) ;// 맵 수정
						tfMoney.setText("");
				}catch(NumberFormatException n ) {
					new MessageBox("출금오류!!", "숫자를 입력하세요");
				}catch(NullPointerException nu) {
					new MessageBox("출금계좌오류!!!", "출금계좌를 선택하세요");
				}
				
			}
		});
		//파일저장 버튼(맵==>파일)
		fileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     File dir = new File("src\\com\\day10\\swing1");
			     File file = new File(dir, "myBank.txt");
			     
			     try {
					FileWriter fw = new FileWriter(file);
				  //  Set<String>	set = hm.keySet();
				   // Iterator<String> it = set.iterator();
					Iterator<String> it = hm.keySet().iterator();
					while(it.hasNext()) {
						String name= it.next(); //키 : 이름
						fw.write(name+"   ");
						fw.write(hm.get(name)+"\n");
					}
					fw.close();
					
				} catch (IOException e1) {
						e1.printStackTrace();
				}
				
			}
		});
		setSize(500, 300);
		setVisible(true);
		load(); //파일 --> 맵
	}
	private void load() {
	     File dir = new File("src\\com\\day10\\swing1");
	     File file = new File(dir, "myBank.txt");
	   try {
		   if(!file.exists()) {
			   file.createNewFile();
			   return;
		   }
		   Scanner sc = new Scanner(file);
		   while(sc.hasNext()) {
			   String name = sc.next() ; //이름
			   int balance = sc.nextInt() ;// 잔액
			   hm.put(name, balance); //맵에 추가
			   lst.add(name+"\n"); //오른쪽 화면  list 에 추가
		   }
	   }catch (IOException e) {
		  e.printStackTrace();
	   }
	}

	public static void main(String[] args) {
		new Bank();

	}

}
