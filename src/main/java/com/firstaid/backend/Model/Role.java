package com.firstaid.backend.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role
{
	private long id;
	private String name;
	private String code;

	@Override
	public String toString()
	{
		return this.code;
	}
}
