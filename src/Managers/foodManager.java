package Managers;

import java.io.FileNotFoundException;

import Common.Food;
import Common.commons;
import FileManager.txtFileManager;

public class foodManager {
	private txtFileManager f;

	public foodManager() throws FileNotFoundException {
		f = new txtFileManager("D:\\\\foods.txt");
		f.CreateFile();
	}
    ////////////////////////////////
	public void insert(Food a) throws FileNotFoundException {
		String S = a.getFoodname() + commons.SPILITTER + a.getNumberfood() + commons.SPILITTER + a.getFoodquantity()
				+ commons.SPILITTER + a.getPrice() + commons.SPILITTER + a.getDesername() + commons.SPILITTER
				+ a.getDrinkname();
		f.appendrow(S);
	}
    /////////////////////////////////
	public Food Splitfood(String s) {
		String A[] = s.split(commons.SPILITTER);
		Food d = new Food();
		d.setFoodname(A[0]);
		d.setNumberfood(Integer.parseInt(A[1]));
		d.setFoodquantity(Integer.parseInt(A[2]));
		d.setPrice(Integer.parseInt(A[3]));
		d.setDesername(A[4]);
		d.setDrinkname(A[5]);
		return d;

	}
    ///////////////////////////////////
	public Food[] SelectAll() throws FileNotFoundException {
		String A[] = f.getarrayfromfile();
		Food B[] = new Food[A.length];
		for (int x = 0; x < A.length; x++) {
			B[x] = Splitfood(A[x]);
		}
		return B;

	}
   ////////////////////////////////////
	public Food[] searchfood(String s) throws FileNotFoundException {
		String B[] = f.getarrayfromfile();
		Food C[] = new Food[B.length];
		int count = 0;
		for (int x = 0; x < B.length; x++) {
			Food food = Splitfood(B[x]);
			if (food.getFoodname().equalsIgnoreCase(s))
				C[count++] = food;

		}
		Food D[] = new Food[count];
		System.arraycopy(C, 0, D, 0, count);
		return D;

	}
    ///////////////////////////////////
	public void Deletfood(int rowfood) throws FileNotFoundException {
		if (rowfood <= 0)
			return;

		String B[] = f.getarrayfromfile();
		String d1 = "";

		for (int x = 0; x < B.length; x++) {
			if (x != rowfood - 1) { // حذف ردیف مشخص شده
				d1 = d1 + B[x];
			}
		}

		f.setintofile(d1.trim());//hazf faseleh
	}
	

}
