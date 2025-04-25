package Common;

public class Customer {
	private String Name;
	private int Numberphone;
	private int MelliCode;
	private String Adress;

	//////////////////////// متد بررسی متن
	public String checkText(String text) {
		if (text != null && text.matches("[a-zA-Z]+"))
			return text;
		else
			return "Error! Enter again";
	}

	//////////////////////// متد بررسی عدد
	public int checkNumber(int n) {
		if (n < 0)
			return 0;
		else
			return n;
	}

	//////////////////////// 
	public String getAdress() {
		return checkText(Adress);
	}

	public void setAdress(String adress) {
		if (checkText(adress) != "Error! Enter again")
			Adress = adress;
	}

	//////////////////////// 
	public String getName() {
		return checkText(Name);
	}

	public void setName(String name) {
		if (checkText(name) != "Error! Enter again")
			Name = name;
	}

	//////////////////////// 
	public int getNumberphone() {
		return checkNumber(Numberphone);
	}

	public void setNumberphone(int numberphone) {
		Numberphone = checkNumber(numberphone);
	}

	//////////////////////// 
	public int getMelliCode() {
		return checkNumber(MelliCode);
	}

	public void setMelliCode(int melliCode) {
		MelliCode = checkNumber(melliCode);
	}
}