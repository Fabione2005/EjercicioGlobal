package com.app.exercise.utils

import java.time.LocalDateTime

import com.app.exercise.model.bean.Phone
import com.app.exercise.model.bean.User

class TestUtilsGroovy {
	
	
	def static User getUser(def name, def email,boolean isActive) {
		LocalDateTime currentTime = LocalDateTime.now();
		List<Phone> tempList = new ArrayList<>();
		tempList.add(new Phone(65464654L, 542L, 47L));

		User user = new User(name, email, "AAcccddser4256", tempList, currentTime, currentTime, currentTime, isActive);
		return user;
	}
	
	def static User getUser(def name, def email) 
	{
		return getUser(name,email,true)
	}
	
}



