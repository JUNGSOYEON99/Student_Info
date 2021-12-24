package student_info;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class modify extends student_info implements ActionListener{
	private int m;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	modify() { //수정함수
		String modi[]= {"이름","전공","휴대전화"};
		
		JFrame mjf=new JFrame();
		mjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mjf.setBounds(100, 100, 352, 369);
		mjf.setTitle("학생 정보 수정");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mjf.setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		mjf.setVisible(true);
		
		JLabel lbl_snum = new JLabel(">> \uD559  \uBC88 : "); //학번 입력 라벨
		lbl_snum.setFont(new Font("굴림", Font.BOLD, 12));
		lbl_snum.setBounds(12, 24, 86, 25);
		contentPane.add(lbl_snum);
		
		JTextField tF_snum = new JTextField(); //검색하고자 하는 학생의 학번을 입력하는 필드
		tF_snum.setBounds(100, 22, 133, 25);
		contentPane.add(tF_snum);
		tF_snum.setColumns(10);
		
		JPanel panel = new JPanel(); //검색한 학생 정보를 띄우는 패널
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 59, 303, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbln = new JLabel("> \uC774     \uB984 : "); //검색한 학생 이름
		lbln.setFont(new Font("굴림", Font.BOLD, 12));
		lbln.setBounds(12, 10, 86, 23);
		panel.add(lbln);
		
		JLabel lblstn = new JLabel("> \uD559     \uBC88 : "); //검색한 학생 학번
		lblstn.setFont(new Font("굴림", Font.BOLD, 12));
		lblstn.setBounds(12, 43, 86, 23);
		panel.add(lblstn);
		
		JLabel lblgen = new JLabel("> \uC131     \uBCC4 : "); //검색한 학생 성별
		lblgen.setFont(new Font("굴림", Font.BOLD, 12));
		lblgen.setBounds(12, 76, 86, 23);
		panel.add(lblgen);
		
		JLabel lblde = new JLabel("> \uD559     \uACFC : "); //검색한 학생 학과
		lblde.setFont(new Font("굴림", Font.BOLD, 12));
		lblde.setBounds(12, 109, 86, 23);
		panel.add(lblde);
		
		JLabel lblpnum = new JLabel("> \uD734\uB300\uC804\uD654 : ");//검색한 학생 전화번호
		lblpnum.setFont(new Font("굴림", Font.BOLD, 12));
		lblpnum.setBounds(12, 144, 86, 23);
		panel.add(lblpnum);
		
		JLabel print_name = new JLabel("");//검색한 학생 이름 출력 라벨
		print_name.setFont(new Font("굴림", Font.BOLD, 12));
		print_name.setBounds(110, 10, 166, 23);
		panel.add(print_name);
		
		JLabel print_stnum = new JLabel("");//검색한 학생 학번 출력 라벨
		print_stnum.setFont(new Font("굴림", Font.BOLD, 12));
		print_stnum.setBounds(110, 43, 166, 23);
		panel.add(print_stnum);
		
		JLabel print_gender = new JLabel("");//검색한 학생 성별 출력 라벨
		print_gender.setFont(new Font("굴림", Font.BOLD, 12));
		print_gender.setBounds(110, 76, 166, 23);
		panel.add(print_gender);
		
		JLabel print_department = new JLabel("");//검색한 학생 학과 출력 라벨
		print_department.setFont(new Font("굴림", Font.BOLD, 12));
		print_department.setBounds(110, 109, 166, 23);
		panel.add(print_department);
		
		JLabel print_pnum = new JLabel("");//검색한 학생 전화번호 출력 라벨
		print_pnum.setFont(new Font("굴림", Font.BOLD, 12));
		print_pnum.setBounds(110, 144, 166, 23);
		panel.add(print_pnum);
		
		JLabel lbl_modify = new JLabel(">> \uC218\uC815\uD560 \uC815\uBCF4 : ");//수정할 정보 선택 라벨
		lbl_modify.setFont(new Font("굴림", Font.BOLD, 12));
		lbl_modify.setBounds(22, 253, 114, 23);
		contentPane.add(lbl_modify);
		
		JButton btnsearch = new JButton("\uAC80   \uC0C9"); //검색버튼
		btnsearch.setBounds(245, 22, 70, 25);
		contentPane.add(btnsearch);
		btnsearch.addActionListener(new ActionListener() { //검색버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				String num=tF_snum.getText();
				int z=0;
				for(int i=0;i<info.length;i++) {
					if(info[i][1]!=null&&info[i][1].isEmpty()==false) {
						String x=info[i][1].trim();
						if(num.equals(x)) {
							print_name.setText(info[i][0].trim());
							print_stnum.setText(info[i][1].trim());
							print_gender.setText(info[i][2].trim());
							print_department.setText(info[i][3].trim());
							print_pnum.setText(info[i][4].trim());
							break;
						}
						z++;
					}
					else {
						z++;
					}
				}
				System.out.println(z);
				System.out.println(info.length);
				if(z==info.length){
					print_name.setText("");
					print_stnum.setText("");
					print_gender.setText("");
					print_department.setText("");
					print_pnum.setText("");
					JOptionPane.showMessageDialog(null, "존재하지 않는 학번입니다.\n다시입력해주세요.");
				}
			}
		});
		
		JTextField tF_modify = new JTextField(); //수정 내용 입력 필드
		tF_modify.setColumns(10);
		tF_modify.setBounds(20, 286, 153, 25);
		contentPane.add(tF_modify);
		
		JComboBox comboBox_modi=new JComboBox(modi);
		comboBox_modi.setBounds(148, 253, 143, 23);  //수정 원하는 내용 선택 콤보박스
		contentPane.add(comboBox_modi);
		DefaultComboBoxModel model=new DefaultComboBoxModel(modi);
		comboBox_modi.setModel(model);
		comboBox_modi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb=(JComboBox)e.getSource();
				int indexx = jcb.getSelectedIndex();
				m=indexx;
			}
		});
		
		JButton btn_modify = new JButton("수   정"); //수정버튼
		btn_modify.setBounds(177, 286, 70, 25);
		contentPane.add(btn_modify);
		btn_modify.addActionListener(new ActionListener() { //수정버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				if(tF_modify.getText()!=null&&tF_modify.getText().isEmpty()==false) {
					if(m==0) { //수정할 내용이 이름
						for(int i=0;i<info.length;i++) {
							if(info[i][0]!=null) {
								String x=info[i][1].trim();
								if(tF_snum.getText().equals(x)) {
									String m=tF_modify.getText();
									info[i][0]=m;
									System.out.println(m);
									break;
								}
							}
						}
						filewrite();
						JOptionPane.showMessageDialog(null, "수정되었습니다!");
						mjf.dispose();
					}
					else if(m==1) { //수정할 내용이 전공
						for(int i=0;i<info.length;i++) {
							if(info[i][0]!=null) {
								String x=info[i][1].trim();
								if(tF_snum.getText().equals(x)) {
									String m=tF_modify.getText();
									info[i][3]=m;
									System.out.println(m);
									break;
								}
							}
						}
						filewrite();
						JOptionPane.showMessageDialog(null, "수정되었습니다!");
						mjf.dispose();
					}
					else if(m==2) { //수정할 내용이 휴대전화
						for(int i=0;i<info.length;i++) {
							if(info[i][0]!=null) {
								String x=info[i][1].trim();
								if(tF_snum.getText().equals(x)) {
									String m=tF_modify.getText();
									info[i][4]=m;
									System.out.println(m);
									break;
								}
							}
						}
						filewrite();
						JOptionPane.showMessageDialog(null, "수정되었습니다!");
						mjf.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "수정 내용을 입력해주세요.");
				}
			}
		});
		
		JButton btn_close = new JButton("취   소");//취소버튼
		btn_close.setBounds(256, 286, 70, 25);
		contentPane.add(btn_close);
		btn_close.addActionListener(new ActionListener() { //취소버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				mjf.dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
