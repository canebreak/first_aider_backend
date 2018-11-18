package com.firstaid.backend.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LongLat
{
	private double longitude;
	private double latitude;

	public LongLat()
	{
	}

	public LongLat(double longitude, double latitude)
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}
}