package student_info;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class delete extends student_info{
	delete() { //학생정보삭제함수
		JFrame djf=new JFrame();
		djf.setTitle("학생 정보 삭제");
		getContentPane().setLayout(null);
		djf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		djf.setBounds(400, 200, 398, 314);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		djf.setContentPane(contentPane);
		contentPane.setLayout(null);
		djf.setVisible(true);
		
		
		JLabel lbl_in_num = new JLabel("* \uD559 \uBC88 \uC785 \uB825 : "); //학번입력라벨
		lbl_in_num.setFont(new Font("굴림", Font.BOLD, 15));
		lbl_in_num.setBounds(15, 20, 102, 32);
		contentPane.add(lbl_in_num);
		
		JTextField tF_in_num = new JTextField();//학번 입력 필드
		tF_in_num.setBounds(124, 23, 147, 23);
		contentPane.add(tF_in_num);
		tF_in_num.setColumns(10);
		
		JLabel lbl_d_name = new JLabel("- \uC774      \uB984 : ");//이름 라벨
		lbl_d_name.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_d_name.setBounds(47, 62, 87, 32);
		contentPane.add(lbl_d_name);
		
		JLabel lbl_d_num = new JLabel("- \uD559      \uBC88 : ");//학번 라벨
		lbl_d_num.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_d_num.setBounds(47, 95, 87, 32);
		contentPane.add(lbl_d_num);
		
		JLabel lbl_d_gender = new JLabel("- \uC131      \uBCC4 : ");//성별 라벨
		lbl_d_gender.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_d_gender.setBounds(47, 132, 87, 32);
		contentPane.add(lbl_d_gender);
		
		JLabel lbl_d_de = new JLabel("- \uC804      \uACF5 : ");//전공 라벨
		lbl_d_de.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_d_de.setBounds(47, 166, 87, 32);
		contentPane.add(lbl_d_de);

		JLabel lbl_d_pnum = new JLabel("- \uD734\uB300\uC804\uD654 : "); //전화번호 라벨
		lbl_d_pnum.setFont(new Font("굴림", Font.BOLD, 14));
		lbl_d_pnum.setBounds(47, 199, 90, 32);
		contentPane.add(lbl_d_pnum);
		
		JLabel lbl_u_name = new JLabel("");//해당 학번 학생 이름 출력
		lbl_u_name.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_u_name.setBounds(140, 62, 160, 30);
		contentPane.add(lbl_u_name);
		
		JLabel lbl_u_num = new JLabel("");//해당 학번 학생 학번 출력
		lbl_u_num.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_u_num.setBounds(140, 98, 160, 30);
		contentPane.add(lbl_u_num);
		
		JLabel lbl_u_gender = new JLabel("");//해당 학번 학생 성별 출력
		lbl_u_gender.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_u_gender.setBounds(140, 135, 160, 30);
		contentPane.add(lbl_u_gender);
		
		JLabel lbl_u_de = new JLabel("");//해당 학번 학생 전공 출력
		lbl_u_de.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_u_de.setBounds(140, 167, 160, 30);
		contentPane.add(lbl_u_de);
	
		JLabel lbl_u_pnum = new JLabel(""); //전화번호 출력
		lbl_u_pnum.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_u_pnum.setBounds(140, 199, 160, 30);
		contentPane.add(lbl_u_pnum);
		
		JButton btn_search = new JButton("\uC870 \uD68C");
		btn_search.setFont(new Font("굴림", Font.PLAIN, 13));
		btn_search.setBounds(288, 23, 69, 23);
		contentPane.add(btn_search);
		btn_search.addActionListener(new ActionListener() { //삭제학생검색버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				String num=tF_in_num.getText();
				int z=0;
				for(int i=0;i<info.length;i++) {
					if(info[i][1]!=null&&info[i][1].isEmpty()==false) {
						String x=info[i][1].trim();
						if(num.equals(x)) {
							lbl_u_name.setText(info[i][0].trim());
							lbl_u_num.setText(info[i][1].trim());
							lbl_u_gender.setText(info[i][2].trim());
							lbl_u_de.setText(info[i][3].trim());
							lbl_u_pnum.setText(info[i][4].trim());
							break;
						}
						z++;
					}
					else {
						z++;
					}
				}
				if(z==info.length) {
					lbl_u_name.setText("");
					lbl_u_num.setText("");
					lbl_u_gender.setText("");
					lbl_u_de.setText("");
					lbl_u_pnum.setText("");
					JOptionPane.showMessageDialog(null, "존재하지 않는 학번입니다.\n다시입력해주세요.");
				}
			}
		});
		
		JButton btn_cancel = new JButton("\uCDE8 \uC18C");
		btn_cancel.setFont(new Font("굴림", Font.PLAIN, 13));
		btn_cancel.setBounds(47, 241, 79, 23);
		btn_cancel.addActionListener(new ActionListener() { //취소버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				djf.dispose();
			}
		});
		contentPane.add(btn_cancel);
		
		JButton btn_delete = new JButton("\uC0AD \uC81C");
		btn_delete.setFont(new Font("굴림", Font.PLAIN, 13));
		btn_delete.setBounds(158, 241, 79, 23);
		btn_delete.addActionListener(new ActionListener() { //삭제버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				String num=tF_in_num.getText();
				for(int i=0;i<info.length;i++) {
					if(info[i][0]!=null) {
						String x=info[i][1].trim();
						if(num.equals(x)) {
							for(int j=0;j<5;j++) {
								info[i][j]=info[i+1][j];
								info[i+1][j]=null;
							}
							n--;
							break;
						}
					}
				}
				filewrite();
				JOptionPane.showMessageDialog(null, "삭제되었습니다!");
				djf.dispose();
			}
		});
		contentPane.add(btn_delete);
		
		JButton btn_delete_all = new JButton("\uC804\uCCB4\uC0AD\uC81C");
		btn_delete_all.setFont(new Font("굴림", Font.PLAIN, 12));
		btn_delete_all.setBounds(268, 241, 79, 23);
		btn_delete_all.addActionListener(new ActionListener() { //전체삭제버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				JFrame nn=new JFrame();

				nn.setTitle("삭제확인");
				nn.setSize(300,150);
				nn.setLocation(500,300);
					
				JPanel p8 = new JPanel();
				p8.setLayout(null);
					
				JLabel l = new JLabel("정말 모든 정보를 삭제하시겠습니까?");
				l.setBounds(60,15,200,32);
				p8.add(l);
					
				JButton c=new JButton("취 소");
				c.setFont(new Font("HY나무L",Font.BOLD,13));
				c.setBounds(50,65,90,32);
				p8.add(c);
					
				JButton e1=new JButton("삭제");
				e1.setFont(new Font("HY나무L",Font.BOLD,13));
				e1.setBounds(130,65,90,32);
				p8.add(e1);
					
				nn.add(p8);
				nn.setVisible(true);
					
				c.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nn.dispose();
					}
				});
				e1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<info.length;i++) {
							for(int j=0;j<5;j++) {
								info[i][j]="";
							}
						}
						n=0;
						filewrite();
						nn.dispose();
						JOptionPane.showMessageDialog(null, "삭제되었습니다!");
						djf.dispose();
					}
				});
			}	
		});
		contentPane.add(btn_delete_all);
	}
}
