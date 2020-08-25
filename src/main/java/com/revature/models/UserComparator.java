package com.revature.models;

import java.util.Comparator;

public class UserComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return ((ERSUser)o1).getUsername().compareTo(((ERSUser)o2).getUsername());
		
	}

}
