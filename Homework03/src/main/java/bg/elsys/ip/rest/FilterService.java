package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterService {
	private static FilterService instance;
	private List<Phone> phoneList = new ArrayList<>();

	public static FilterService getInstance() {
		if (instance == null) {
			instance = new FilterService();
		}
		return instance;
	}
	 
	
	public List<Phone> filter(Filter filter) {
		phoneList = PhoneService.getInstance().getPhones();
		
		List<Phone> list = new ArrayList<>();
		if(filter.isDeveloper() && !filter.isPrice() && !filter.isStorage())
		{
			
			devFilter(filter, list);
		}
		else if(filter.isModel() && !filter.isPrice() && !filter.isStorage())
		{
			
			modelFilter(filter, list);
		}
		else if(filter.isPrice() && !filter.isDeveloper() && !filter.isModel() && !filter.isStorage())
		{
			
			priceFilter(filter, list);
		}
		else if(filter.isStorage() && !filter.isDeveloper() && !filter.isModel() && !filter.isPrice())
		{
			
			storageFilter(filter, list);
		}
		else if(filter.isDeveloper() && filter.isPrice() && !filter.isStorage())
		{
			
			devPriceFilter(filter, list);
		}
		else if(filter.isDeveloper() && !filter.isPrice() && filter.isStorage())
		{
			
			devStorageFilter(filter, list);
		}
		else if(filter.isDeveloper() && filter.isPrice() && filter.isStorage())
		{
			
			devPriceStorageFilter(filter, list);
		}
		else if(filter.isModel() && filter.isPrice() && !filter.isStorage())
		{
			
			modelPriceFilter(filter, list);
		}
		else if(filter.isModel() && !filter.isPrice() && filter.isStorage())
		{
			
			modelStorageFilter(filter, list);
		}
		else if(filter.isModel() && filter.isPrice() && filter.isStorage())
		{
			
			modelStoragePriceFilter(filter, list);
		}
		else if(filter.isPrice() && filter.isStorage())
		{
			
			priceStorageFilter(filter, list);
		}
		phoneList = list;
		return Collections.unmodifiableList(phoneList);
	}


	private void priceStorageFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if((phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage())
					&& (phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice()))
			{
				list.add(phone);
			}
		}
	}


	private void modelStoragePriceFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getModel()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) 
					&& (phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage())
					&& (phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice()))
			{
				list.add(phone);
			}
		}
	}


	private void modelStorageFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getModel()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) && (phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage()))
			{
				list.add(phone);
			}
		}
	}


	private void modelPriceFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getModel()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) && (phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice()))
			{
				list.add(phone);
			}
		}
	}


	private void devPriceStorageFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getDeveloper()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) 
					&& (phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage())
					&& (phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice()))
			{
				list.add(phone);
			}
		}
	}


	private void devStorageFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getDeveloper()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) && (phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage()))
			{
				list.add(phone);
			}
		}
	}


	private void devPriceFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getDeveloper()
					.toLowerCase()
					.contains(filter.getFilter().toLowerCase()) && (phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice()) )
			{
				list.add(phone);
			}
		}
	}


	private void storageFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getStorage() >= filter.getLowerStorage() && phone.getStorage() <= filter.getHigherStorage())
			{
				list.add(phone);
			}
		}
	}


	private void priceFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getPrice() >= filter.getLowerPrice() && phone.getPrice() <= filter.getHigherPrice())
			{
				list.add(phone);
			}
		}
	}


	private void devFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getDeveloper().toLowerCase().contains(filter.getFilter().toLowerCase()))
			{
				list.add(phone);
			}
		}
	}

	private void modelFilter(Filter filter, List<Phone> list) {
		for(Phone phone: phoneList)
		{
			if(phone.getModel().toLowerCase().contains(filter.getFilter().toLowerCase()))
			{
				list.add(phone);
			}
		}
	}

}
