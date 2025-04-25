package Managers;

import java.io.FileNotFoundException;

import Common.Food;
import Common.Member;
import Common.commons;
import FileManager.txtFileManager;

public class MemberManager {
	private txtFileManager member;

	public MemberManager() throws FileNotFoundException {
		member = new txtFileManager("D:\\\\Member.txt");
		member.CreateFile();

	}

	public void insert(Member a) throws FileNotFoundException {
		String B = a.getSttafName() + commons.SPILITTER + a.getMelliCode() + commons.SPILITTER + a.getNumberPhone()
				+ commons.SPILITTER + a.getSttafAddress() + commons.SPILITTER;
		member.appendrow(B);
	}

	public Member split(String a) {
		String A[] = a.split(commons.SPILITTER);
		Member d = new Member();
		d.setSttafName(A[0]);
		d.setMelliCode(Integer.parseInt(A[1]));
		d.setNumberPhone(Integer.parseInt(A[2]));
		d.setSttafAddress(A[3]);
		return d;
	}

	public Member[] SelectAll() throws FileNotFoundException {
		String A[] = member.getarrayfromfile();
		Member B[] = new Member[A.length];
		for (int x = 0; x < A.length; x++) {
			B[x] = split(A[x]);
		}
		return B;

	}

	public Member[] searchfood(String s) throws FileNotFoundException {
		String B[] = member.getarrayfromfile();
		Member C[] = new Member[B.length];
		int count = 0;
		for (int x = 0; x < B.length; x++) {
			Member member = split(B[x]);
			if (member.getSttafName().equalsIgnoreCase(s))
				C[count++] = member;

		}
		Member D[] = new Member[count];
		System.arraycopy(C, 0, D, 0, count);
		return D;

	}

	public void Deletmember(int rowmember) throws FileNotFoundException {
		if (rowmember <= 0)
			return;

		String B[] = member.getarrayfromfile();
		String d1 = "";

		for (int x = 0; x < B.length; x++) {
			if (x != rowmember - 1) { // حذف ردیف مشخص شده
				d1 = d1 + B[x];
			}
		}

		member.setintofile(d1.trim());// hazf faseleh
	}

	public void updateMember(String newmember, Member updatedMember) throws FileNotFoundException {
		String updatedData = updatedMember.getSttafName() + commons.SPILITTER + updatedMember.getMelliCode()
				+ commons.SPILITTER + updatedMember.getNumberPhone() + commons.SPILITTER
				+ updatedMember.getSttafAddress();
		member.update(newmember, updatedData);
	}

}
