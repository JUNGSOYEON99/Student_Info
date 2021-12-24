package student_info;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class search extends student_info{
	search() { //모든 학생 정보 출력 함수
		JFrame pjf=new JFrame();
		pjf.setTitle("학생 정보 검색");
		pjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pjf.setBounds(100, 100, 565, 350);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		pjf.setContentPane(contentPane);
		contentPane.setLayout(null);
		pjf.setVisible(true);
		String[] data=new String[5];//테이블에 값을 넣기위한 배열
		
		String header[]= {" 이름","  학번    "," 성별   " ,"      전공       ","   휴대전화   "};//메뉴테이블
		DefaultTableModel model = new DefaultTableModel(header,0);
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(table);
		
		DefaultTableCellRenderer dtc=new DefaultTableCellRenderer();
		dtc.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc=table.getColumnModel();
		for(int i=0;i<tc.getColumnCount();i++) {
			tc.getColumn(i).setCellRenderer(dtc);
		}
		contentPane.add(scrollPane);
		scrollPane.setBounds(12, 52, 521, 214);
		
		JButton btn_close = new JButton("\uB2EB    \uAE30");
		btn_close.setFont(new Font("굴림", Font.PLAIN, 13));
		btn_close.setBounds(453, 276, 80, 23);
		btn_close.addActionListener(new ActionListener() { //검색버튼 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				pjf.dispose();
			}
		});
		contentPane.add(btn_close);	
		
		JLabel lbl_st_name = new JLabel("* 학생 이름 : ");
		lbl_st_name.setFont(new Font("굴림", Font.BOLD, 13));
		lbl_st_name.setBounds(12, 19, 80, 23);
		contentPane.add(lbl_st_name);
		
		JTextField tF_stname = new JTextField();
		tF_stname.setBounds(103, 19, 107, 22);
		contentPane.add(tF_stname);
		tF_stname.setColumns(10);
		
		JButton btn_search = new JButton("검 색");
		btn_search.setBounds(229, 19, 63, 23);
		contentPane.add(btn_search);
		btn_search.addActionListener(new ActionListener() { //학생 학번 검색
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0); //테이블 초기화
				int z=0;
				String num=tF_stname.getText();
				for(int i=0;i<info.length;i++) {
					if(info[i][1]!=null) {
						String x=info[i][0].trim();
						if(num.equals(x)) {
							for(int a=0;a<5;a++) {
								data[a]=info[i][a];
							}
							model.addRow(data);
							z++;
						}
					}
					else if(z==0){
						JOptionPane.showMessageDialog(null, "존재하지 않는 이름입니다.\n다시입력해주세요.");
						break;
					}
				}
			}
		});
		
		JButton btn_search_all = new JButton("전체검색");
		btn_search_all.setFont(new Font("굴림", Font.BOLD, 11));
		btn_search_all.setBounds(429, 19, 84, 23);
		contentPane.add(btn_search_all);
		btn_search_all.addActionListener(new ActionListener() { //저장되어 있는 모든 정보 출력
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0); //테이블 초기화
				if(n>0) {
					for(int j=0;j<n;j++) {
						for(int a=0;a<5;a++) {
							data[a]=info[j][a];
						}
						if(info[j][1]!=null) {
							model.addRow(data);
						}
					}
				}
				else {
					model.setNumRows(0);
					JOptionPane.showMessageDialog(null, "저장된 학생 정보가 없습니다.");
				}
			}
		});
	}
}
