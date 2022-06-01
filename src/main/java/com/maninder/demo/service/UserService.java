package com.maninder.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.maninder.demo.repository.UserRepository;
import com.maninder.demo.transferobject.UserResponseTO;
import com.maninder.demo.transferobject.UserTO;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	

	public UserResponseTO getUsers(String lastName, Integer age, int pageNo, int pageSize, String sortBy, String sortDir) {
		
		 Page<UserTO> userPage = null;
		 Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
		
		 Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		 if(lastName != null && age != null) {
			 userPage = userRepo.findByNameEndingWithAndAge(" " +lastName, age, pageable);
		 } else if (lastName != null && age == null) {
			 userPage = userRepo.findByNameEndingWith(" " + lastName, pageable);
		 } else if(age != null && lastName == null) {
			 userPage = userRepo.findAllByAge(age, pageable);
		 } else {
			 userPage = userRepo.findAllProjectedBy(pageable);
		 }
		 
		 UserResponseTO uto = new UserResponseTO();
		 uto.setUsers(userPage.getContent());
		 uto.setTotalPages(userPage.getTotalPages());
		 uto.setTotalElements(userPage.getTotalElements());
		 uto.setPageSize(userPage.getSize());
		 uto.setPageNo(userPage.getNumber());
		 uto.setLast(userPage.isLast());
		 return uto; 
		 
	}

}
