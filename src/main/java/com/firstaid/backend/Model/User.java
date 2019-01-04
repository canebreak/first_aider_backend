package com.firstaid.backend.Model;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User
{
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;
	private List<Role> roles;
	private String password;
}
