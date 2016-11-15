package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneService {
	private static PhoneService instance;

	public static PhoneService getInstance() {
		if (instance == null) {
			instance = new PhoneService();
		}
		return instance;
	}
	
	private List<Phone> phoneList = new ArrayList<>();

	public PhoneService() {
		phoneList.add(new Phone(1, "Samsung", "Galaxy S6 Edge Plus",32,468.00));
		phoneList.add(new Phone(2, "Samsung", "Galaxy S7 Edge",32,617.00));
		phoneList.add(new Phone(3, "Samsung", "Galaxy S6",128,649.00));
		phoneList.add(new Phone(4, "Samsung", "Galaxy S7",32,535.00));
		phoneList.add(new Phone(5, "Apple", "iPhone 6",64,514.00));
		phoneList.add(new Phone(6, "Apple", "iPhone 7",128,848.01));
		phoneList.add(new Phone(7, "Apple", "iPhone 7 Plus",128,1050.00));
		phoneList.add(new Phone(8, "Apple", "iPhone 6S Plus",16,649.00));
		phoneList.add(new Phone(9, "HTC", "10",64,699.00));
		phoneList.add(new Phone(10, "HTC", "One M9+",32,399.00));
		phoneList.add(new Phone(11, "HTC", "One M9",32,390.00));
		phoneList.add(new Phone(12, "HTC", "One A9",32,309.99));
		phoneList.add(new Phone(13, "Huawei", "P9",32,499.95));
		phoneList.add(new Phone(14, "Huawei", "P9 Plus",64,656.38));
		phoneList.add(new Phone(15, "Huawei", "Nexus 6p",32,549.00));
		phoneList.add(new Phone(16, "Huawei", "Mate 8",65,493.88));
		phoneList.add(new Phone(17, "LG", "V20",64,625.99));
		phoneList.add(new Phone(18, "LG", "V10",64,299.00));

	}

	public List<Phone> getPhones() {
		return Collections.unmodifiableList(phoneList);
	}

	public void addPhone(Phone phone) {
		phoneList.add(phone);
	}
}
