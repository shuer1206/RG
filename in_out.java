package demo;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class in_out extends JFrame{

	public static void main(String[] args) {
		in_out frame=new in_out();
		frame.setVisible(true);
		frame.setBounds(100,100,1000,500);
		frame.setTitle("���ݴ���");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public in_out() {
		getContentPane().setLayout(null);
		Container c=getContentPane();
		
		JLabel l1=new JLabel("�ļ�Դ��ַ��");
		l1.setFont(new Font("����",Font.PLAIN,25));
		l1.setBounds(20, 0, 200, 80);
		c.add(l1);
		
		JTextField t1=new JTextField();
		t1.setBounds(230,5,700,60);
		t1.setFont(new Font("����",Font.PLAIN,20));
		c.add(t1);
		
		JLabel l2=new JLabel("�ļ�Ŀ���ַ��");
		l2.setFont(new Font("����",Font.PLAIN,25));
		l2.setBounds(20,80,200,80);
		c.add(l2);
		
		JTextField t2=new JTextField();
		t2.setBounds(230,85,700,60);
		t2.setFont(new Font("����",Font.PLAIN,20));
		c.add(t2);
		
		JLabel l3=new JLabel("�����ݽ��а�ʡ�ݹ���!");
		l3.setFont(new Font("����",Font.PLAIN,25));
		l3.setBounds(350, 150,600, 80);
		c.add(l3);
		
		JButton b=new JButton("ȷ��");
		b.setBounds(430,230, 120,50);
		b.setFont(new Font("����",Font.PLAIN,25));
		b.setBackground(Color.LIGHT_GRAY);
		c.add(b);
		
		JTextField t3=new JTextField();
		t3.setBounds(438,320,110,60);
		t3.setFont(new Font("����",Font.PLAIN,20));
		c.add(t3);
		
		b.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				b.setBackground(Color.LIGHT_GRAY);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				b.setBackground(Color.BLUE);
				String file1=t1.getText();
				String file2=t2.getText();
				try {
					deal(file1,file2);  //����deal�������������ݴ���
					t3.setText("����ɹ���");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}

	  
	void deal(String a,String b) throws IOException{
		String[] data =new String[129];  //һ����129������
		
		try {
			File source=new File(a);   //�����ļ�
			FileReader fr=new FileReader(source);
			BufferedReader reader=new BufferedReader(fr);
			int index=0; 
			String str;
			while((str=reader.readLine()) != null) {
				data[index]=str;  //���ж�������
				index++;
			}
			
			File target=new File(b);  //����ļ�
			FileWriter fw=new FileWriter(target);
			BufferedWriter write=new BufferedWriter(fw);
			String province=data[0].substring(0, 3);  //�����һ�����ݵ�ʡ��
			write.append(province+"\n");
			for(int i=0;i<data.length;i++)
			{
				String[] str1=data[i].split("\t");
				if(str1[0].equals(province)) {
					if(!str1[2].equals("0")) {
					write.append(str1[1]+"\t"+str1[2]+"\n");
					}
				}else {
					province=str1[0];
					write.append("\n");
					write.append(province+"\n");
				}
			}
			write.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}