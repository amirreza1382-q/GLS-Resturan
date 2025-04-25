package FileManager;

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

	public void appendrow(String row) throws FileNotFoundException {
		String b = getfromfile();
		if (b == "")
			b = row;
		else
			b = b + '\n' + row;
		setintofile(b);

	}

	public void addFood(String foodName, int foodNumber, int price, int quantity) throws FileNotFoundException {
		if (price < 0 || quantity < 0) {
			System.out.println("Eror");
			return;
		}
		String newFood = foodName + ", " + foodNumber + ", " + price + "$, " + quantity;
		appendrow(newFood); // اضافه کردن غذا به فایل
	}

	public void setintofile(String a) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("D:\\food.txt");
		out.print(a);
		out.close();
	}

	private String getfromfile() throws FileNotFoundException {
		String P = "";
		File file = new File(this.FileName);
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			P = P + input.nextLine() + "\n";
		}
		input.close();
		return P;
	}

	public String[] getarrayfromfile() throws FileNotFoundException {
		File file = new File(this.FileName);
		String s[] = new String[Row];
		int cS = 0;
		Scanner input = new Scanner(file);
		while (input.hasNextLine())
			s[cS++] = input.nextLine() + '\n';
		return s;

	}

	////////////////////////// Create File
	public void CreateFile() throws FileNotFoundException {

		setintofile("");
	}

	public void Clear() throws FileNotFoundException {
		CreateFile();

	}

	public void delet(String a) throws FileNotFoundException {
		String[] A = getarrayfromfile();
		StringBuilder delet = new StringBuilder();

		for (int x = 0; x < A.length; x++) {
			if (!A[x].contains(a)) {
				delet.append(A[x]).append("\n");
			}
		}

		setintofile(delet.toString().trim()); 
	}
	public void update(String C, String updatedData) throws FileNotFoundException {
	    String[] A = getarrayfromfile();
	    String d1 = "";

	    for (int x = 0; x < A.length; x++) {
	        if (!A[x].contains(C)) {
	            d1 = d1 + A[x]; // حفظ داده‌های دیگر
	        } else {
	            d1 = d1 + updatedData; 
	        }
	    }

	    setintofile(d1.trim()); 
	}
	
}