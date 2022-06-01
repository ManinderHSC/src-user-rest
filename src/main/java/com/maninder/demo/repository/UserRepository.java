package com.maninder.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maninder.demo.domain.User;
import com.maninder.demo.transferobject.UserTO;


public interface UserRepository extends JpaRepository<User, Integer>{

	Page<UserTO> findByNameEndingWithAndAge(String lastName, Integer age, Pageable pageable);

	Page<UserTO> findByNameEndingWith(String lastName, Pageable pageable);

	Page<UserTO> findAllByAge(Integer age, Pageable pageable);

	Page<UserTO> findAllProjectedBy(Pageable pageable);
	


}
