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

	public void deletfood(String foodName) throws FileNotFoundException {
		String[] food = getarrayfromfile();
		StringBuilder delet = new StringBuilder();

		for (int x = 0; x < food.length; x++) { // استفاده از index به جای foreach
			if (!food[x].contains(foodName)) {
				delet.append(food[x]).append("\n");
			}
		}

		setintofile(delet.toString().trim()); // حذف فضای اضافی
	}
}