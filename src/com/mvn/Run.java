package com.mvn;


import org.apache.log4j.Logger;

import com.model.Person;

public class Run{
	
	private static Logger logger = Logger.getLogger(Run.class);
	public static void main(String[] args) {
		Person p = new Person("Bill");
		logger.info("person name : "+p.getName());
	}
}
