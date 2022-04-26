package sample06;

import java.util.List;

public class ListBean { //<bean class="ListBean"
	private List<Integer> intList;
	private List<String> strList;
	private List<Customer> customerList;
	
	public void setIntList(List<Integer> intList) {
		this.intList = intList;
		System.out.println("setIntList(List<Integer> intList) : " + intList);
	}
	
	public void setStrList(List<String> strList) {
		this.strList = strList;
		System.out.println("setStrList(List<String> strList) : " + strList);
	}
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
		System.out.println("setCustomerList(List<Customer> customerList) : " + customerList);
	}
	
	
}
