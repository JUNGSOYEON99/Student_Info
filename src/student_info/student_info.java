package student_info;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class student_info extends JFrame{
	//public JFrame si=new JFrame();
	private JPanel contentPane;
	String[][] info=new String[200][6]; //학생 정보 저장 배열
	int n=0;
	String gender; //성별
	String de=null; //학과

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_info frame = new student_info();
					frame.setVisible(true);
					//fileread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void filewrite(){ //파일입력
		try {
			FileWriter fw=new FileWriter("C:\\Users\\OWNER\\eclipse-workspace\\student_info\\src\\student_info\\student.txt",false);//해당 파일이 존재할 경우 덮어쓰기
			//BufferedWriterwriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "euc-kr"));
			for(int i=0;i<info.length;i++) {
				if(info[i][1]!=null&&info[i][1].isEmpty()==false) {
					String str=info[i][0]+"/"+info[i][1]+"/"+info[i][2]+"/"+info[i][3]+"/"+info[i][4]+"\n";
					fw.write(str);
					System.out.println(str);
				}
				else{
					fw.write("");
				}
			}
			fw.close();
			System.out.println("저장완료");
		} catch(IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileread() { //파일 내용 배열에 저장
	      try {
	    	  File file=new File("C:\\Users\\OWNER\\eclipse-workspace\\student_info\\src\\student_info\\student.txt"); //euc-kr
	          BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")); //한글깨짐 방지
 
	         String line="";
	         while((line=br.readLine())!=null) {
	            //System.out.println(line);
	            String[] str2=line.split("/");
	            for(int kk=0;kk<str2.length;kk++) { //텍스트 파일에 저장된 내용을 구분자로 구분하여 배열에 저장
	            	info[n][kk]=str2[kk];
	            }
	            n++; //배열에 저장되어 있는 학생의 수
	         }
	         br.close();
	      } catch(FileNotFoundException e) {
	         //TODO: handle exception
	      }catch(IOException e) {
	         System.err.println("IO eror");
	      }
	}
	
	public void DBcon() {//db연결함수
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert() { //등록함수	
		String department[]= {"정보보안학과","정보통신공학과","컴퓨터공학과"}; //combobox에 입력될 학과들
		
		JFrame ijf=new JFrame();
		ijf.setTitle("학생 정보 등록");
		ijf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ijf.setBounds(100, 100, 363, 375);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ijf.setContentPane(contentPane);
		contentPane.setLayout(null);
		ijf.setVisible(true);
		
		JLabel lbl_name = new JLabel("* \uC774     \uB984 : ");
		lbl_name.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_name.setBounds(27, 27, 84, 25);
		contentPane.add(lbl_name);
		
		JLabel lbl_gender = new JLabel("* \uC131     \uBCC4 : ");
		lbl_gender.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_gender.setBounds(27, 122, 84, 25);
		contentPane.add(lbl_gender);
		
		JLabel lbl_department = new JLabel("* 전     공 : ");
		lbl_department.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_department.setBounds(27, 170, 84, 25);
		contentPane.add(lbl_department);
		
		JLabel lbl_pnum = new JLabel("* \uD734\uB300\uC804\uD654 : ");
		lbl_pnum.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_pnum.setBounds(27, 219, 84, 25);
		contentPane.add(lbl_pnum);
		
		JLabel lbl_student_num = new JLabel("* \uD559     \uBC88 : ");
		lbl_student_num.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_student_num.setBounds(27, 73, 84, 25);
		contentPane.add(lbl_student_num);
		
		JTextField tF_name = new JTextField();
		tF_name.setBounds(118, 25, 161, 25);
		contentPane.add(tF_name);
		tF_name.setColumns(10);
		
		JTextField tF_st_num = new JTextField();
		tF_st_num.setColumns(10);
		tF_st_num.setBounds(118, 73, 161, 25);
		contentPane.add(tF_st_num);
		
		JRadioButton rdbtn_m = new JRadioButton("\uB0A8");
		rdbtn_m.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtn_m.setBounds(129, 123, 39, 23);
		contentPane.add(rdbtn_m);
		
		JRadioButton rdbtn_w = new JRadioButton("\uC5EC");
		rdbtn_w.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtn_w.setBounds(199, 123, 39, 23);
		contentPane.add(rdbtn_w);
		
		ButtonGroup bg_gender=new ButtonGroup();//현금,카드 라디오 버튼 그룹화
		bg_gender.add(rdbtn_m); 
		bg_gender.add(rdbtn_w);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 168, 161, 23);
		contentPane.add(comboBox);
		DefaultComboBoxModel model3=new DefaultComboBoxModel(department);
		comboBox.setModel(model3);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb=(JComboBox)e.getSource();
				int indexx = jcb.getSelectedIndex();
				de=department[indexx];
			}
		});
		
		JLabel lbl_numset = new JLabel("010 - ");
		lbl_numset.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_numset.setBounds(118, 224, 50, 15);
		contentPane.add(lbl_numset);
		
		JTextField tF_pnum = new JTextField();
		tF_pnum.setColumns(10);
		tF_pnum.setBounds(160, 218, 50, 25);
		contentPane.add(tF_pnum);
		
		JLabel lbl_ = new JLabel(" - ");
		lbl_.setFont(new Font("굴림", Font.PLAIN, 15));
		lbl_.setBounds(210, 218, 50, 25);
		contentPane.add(lbl_);
		
		JTextField tF_pnum2 = new JTextField();
		tF_pnum2.setColumns(10);
		tF_pnum2.setBounds(230, 218, 50, 25);
		contentPane.add(tF_pnum2);
		
		JButton btn_insert = new JButton("\uC800     \uC7A5");
		btn_insert.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_insert.setBounds(54, 278, 88, 26);
		contentPane.add(btn_insert);
		btn_insert.addActionListener(new ActionListener() { //등록버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				if(tF_name.getText().equals("") || tF_st_num.getText().equals("") || rdbtn_m.isSelected()==false && rdbtn_w.isSelected()==false ||
						tF_pnum.getText().equals("")) {
					if(tF_name.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력해주세요!");
					}
					else if(tF_st_num.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "학번을 입력해주세요!");
					}
					else if(rdbtn_m.isSelected()==false && rdbtn_w.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "성별을 선택해주세요!");
					}
					else if(tF_pnum.getText().equals("") || tF_pnum2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "휴대전화를 입력해주세요!");
					}
				}
				else {
					if(rdbtn_m.isSelected()==true) {
						gender="남";
					}
					if(rdbtn_w.isSelected()==true) {
						gender="여";
					}

					info[n][0]=tF_name.getText(); //이름저장
					System.out.println(tF_name.getText());
					info[n][1]=tF_st_num.getText(); //학번저장
					info[n][2]=gender; //성별저장
					info[n][3]=de; //전공저장
					info[n][4]="010-"+tF_pnum.getText()+"-"+tF_pnum2.getText();//전화번호저장
					n++; //배열에 저장된 학생수 ++

					filewrite();
					JOptionPane.showMessageDialog(null, "저장완료");
					ijf.dispose();//등록 프레임 닫기
				}
			}
		});
		
		JButton btn_c = new JButton("\uCDE8     \uC18C"); //취소버튼
		btn_c.setFont(new Font("굴림", Font.PLAIN, 15));
		btn_c.setBounds(198, 278, 88, 26);
		contentPane.add(btn_c);
		btn_c.addActionListener(new ActionListener() { //취소버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				ijf.dispose();//등록 프레임 닫기
			}
		});
	}
	
	void print() {
		for(int i=0;i<=n;i++) {
			if(info[i][0]!=null) {
			for(int j=0;j<5;j++) {
				System.out.println(info[i][j]);
			}
		}
		}
	}
	student_info() {
		setTitle("학생 정보 관리 프로그램");
		//getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setVisible(true);

		fileread();//텍스트 파일 내용 읽어서 배열에 저장
		
		JButton insert_bt = new JButton("등      록"); //등록버튼
		insert_bt.setBounds(155, 29, 166, 35);
		contentPane.add(insert_bt);
		insert_bt.addActionListener(new ActionListener() { //등록버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		
		JButton search_bt = new JButton("검      색");
		search_bt.setBounds(155, 91, 166, 35);
		contentPane.add(search_bt);
		search_bt.addActionListener(new ActionListener() { //검색버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				new search();
			}
		});
		
		JButton modify_bt = new JButton("수     정");
		modify_bt.setBounds(155, 151, 166, 35);
		contentPane.add(modify_bt);
		modify_bt.addActionListener(new ActionListener() { //수정버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				new modify();
			}
		});
		
		JButton delete_bt = new JButton("삭      제");
		delete_bt.setBounds(155, 213, 166, 35);
		contentPane.add(delete_bt);
		delete_bt.addActionListener(new ActionListener() { //삭제버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				new delete();
			}
		});
		
		JButton exit_bt = new JButton("종    료");
		exit_bt.setBounds(396, 258, 80, 25);
		contentPane.add(exit_bt);
		exit_bt.addActionListener(new ActionListener() { //종료버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				JFrame f3=new JFrame();

				f3.setTitle("종료확인");
				f3.setSize(300,150);
				f3.setLocation(500,300);
					
				JPanel p4 = new JPanel();
				p4.setLayout(null);
					
				JLabel l = new JLabel("정말 종료하시겠습니까?");
				l.setBounds(60,15,200,32);
				p4.add(l);
					
				JButton c=new JButton("취 소");
				c.setFont(new Font("HY나무L",Font.BOLD,13));
				c.setBounds(50,65,90,32);
				p4.add(c);
					
				JButton e1=new JButton("종 료");
				e1.setFont(new Font("HY나무L",Font.BOLD,13));
				e1.setBounds(130,65,90,32);
				p4.add(e1);
					
				f3.add(p4);
				f3.setVisible(true);
					
				c.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f3.dispose();
					}
				});
				e1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//filewrite();
						f3.dispose();
						dispose();
					}
				});
			}			
		});
	}
}
