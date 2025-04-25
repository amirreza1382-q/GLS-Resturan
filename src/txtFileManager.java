import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txtFileManager {
	private String FileName;
	private int Row;

	public txtFileManager(String FileName) {
		this.FileName = FileName;
	}
	public void appendrow(String row) throws FileNotFoundException
	{
		String b=getfromfile();
		if(b=="")
			b=row;
		else
			b=b+'\n'+row;
		setintofile(b);
		
	}
	private void setintofile(String a) throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter("D:\\food.txt");
		out.print(a);
		out.close();
	}
	private String getfromfile() throws FileNotFoundException
	{
		String P="";
		File file=new File(this.FileName);
		Scanner input=new Scanner(file);
		while(input.hasNextLine())
		{
			P=P+input.nextLine()+"\n";
		}
		input.close();
		return P;
	}
	private String[] getarrayfromfile() throws FileNotFoundException
	{
		File file=new File(this.FileName);
		String s[]=new String[Row];
		int cS=0;
		Scanner input=new Scanner(file);
		while(input.hasNextLine())
			s[cS++]=input.nextLine()+'\n';
		return s;
			
	}
	////////////////////////// Create File
	public void CreateFile() throws FileNotFoundException {
	
    setintofile("");
	}

	public void Clear() throws FileNotFoundException {
		CreateFile();

	}
	public void deletrow(int row) throws FileNotFoundException
	{
		if(row<=0||row>Row)
			return;
		String d[]=getarrayfromfile();
		String d1="";
		for(int x=0;x<d.length;x++)
			if(x!=row-1)
				d1=d1+d[x];
		setintofile(d1);
	}
}