package com.firstaid.backend.Model;

import org.springframework.data.geo.Point;

public class Event
{
	private long id;
	private String name;
	private Point location; // LongLat loaction
	private long userId;
	private long eventTypeId;
}

