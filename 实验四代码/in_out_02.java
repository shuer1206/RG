package demo;
import java.io.*;
import java.util.Scanner;

public class in_out_02 {
	public static void main(String[] args) throws IOException {
		deals();
	}
	static void deals() throws IOException{
		Scanner sc=new Scanner(System.in);
		City[] c =new City[129];  //一共有129条数据
		String adress = sc.nextLine();
		String[] adr = adress.split(" ");
		String d1 = adr[0];
		String d2 = adr[1];
		try {
			File source=new File(d1);  //输入文件
			FileReader fr = new FileReader(source);
			BufferedReader reader=new BufferedReader(fr);
			int index=0; 
			String str;
			String[] s=new String[3];
			while((str=reader.readLine()) != null) {
				s=str.split("\t");  //逐行读进数组
				c[index]=new City();
				c[index].province=s[0];
				c[index].city=s[1];
				c[index].num=Integer.parseInt(s[2]);
				index++;
			}
			
			//获取有几个省份
			String province=c[0].province;  //输出第一行数据的省份
			int n=1;
			for(int i=0;i<c.length;i++) 
			{
				if(!c[i].province.equals(province)) {
					province=c[i].province;
					n++;
				}
			}
//			System.out.println(n); //获取有几个省份
			
			
			P_Num[] cn =new P_Num[n];  //存放省份和其总数据
			int p=0;
			province=c[0].province;
			cn[p]=new P_Num();
			cn[p].Cprovince=province;
			for(int i=0;i<c.length;i++)
			{
				if(c[i].province.equals(province)) {
					cn[p].Cnum+=c[i].num;
				}else {
					province=c[i].province;
					p++;
					cn[p]=new P_Num();
					cn[p].Cprovince=province;
				}
			}
			
//			for(int i=0;i<n;i++)  输出省份和其总数据
//			{
//				System.out.println(cn[i].Cprovince+"\t"+cn[i].Cnum);
//			}
	
			
			String Ptmp=new String();  //对省份和数据从大到小排序
			int Ntmp=0;
			for(int i=0;i<n;i++)
			{
				for(int j=i+1;j<n;j++) {
					if(cn[i].Cnum<cn[j].Cnum) {
						Ptmp=cn[i].Cprovince;
						Ntmp=cn[i].Cnum;
						cn[i].Cprovince=cn[j].Cprovince;
						cn[i].Cnum=cn[j].Cnum;
						cn[j].Cprovince=Ptmp;
						cn[j].Cnum=Ntmp;
					}
				}
			}
			
			String Ptmp1=new String();  //每个省的城市和数据从大到小排序
			String Ctmp1=new String();
			int Ntmp1=0;
			for(int i=0;i<c.length;i++)
			{
				for(int j=i+1;j<c.length;j++)
				{
					if(c[i].num<c[j].num) {
						Ptmp1=c[i].province;
						Ctmp1=c[i].city;
						Ntmp1=c[i].num;
						c[i].province=c[j].province;
						c[i].city=c[j].city;
						c[i].num=c[j].num;
						c[j].province=Ptmp1;
						c[j].city=Ctmp1;
						c[j].num=Ntmp1;
					}else if(c[i].num==c[j].num) {
						if(c[i].city.charAt(0)>c[j].city.charAt(0)) {
							Ptmp1=c[i].province;
							Ctmp1=c[i].city;
							Ntmp1=c[i].num;
							c[i].province=c[j].province;
							c[i].city=c[j].city;
							c[i].num=c[j].num;
							c[j].province=Ptmp1;
							c[j].city=Ctmp1;
							c[j].num=Ntmp1;
						}
					}
				}
			}
			
			
			File target=new File(d2);  //输出文件
			FileWriter fw=new FileWriter(target);
			BufferedWriter write=new BufferedWriter(fw);
			for(int i=0;i<n;i++)  //对排好总数顺序的省份进行输出
			{
				String p1=cn[i].Cprovince;
//				System.out.println(p1+"\t"+cn[i].Cnum);
				write.append(p1+"\t"+cn[i].Cnum);
				write.append("\n");
				for(int j=0;j<c.length;j++)
				{
					if(c[j].province.equals(p1))
					{
//						System.out.println(c[j].city+"\t"+c[j].num);
						write.append(c[j].city+"\t"+c[j].num);
						write.append("\n");
					}		
				}
//				System.out.println();
				write.append("\n");
			}
			System.out.println("数据操作成功！");
			write.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


/*C:\Users\x\Desktop\软件工程课程设计实验\实验四\in.txt C:\Users\x\Desktop\软件工程课程设计实验\实验四\out.txt*/