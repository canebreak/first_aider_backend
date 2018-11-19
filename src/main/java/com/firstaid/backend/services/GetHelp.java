package com.firstaid.backend.services;

import com.firstaid.backend.Model.Event;

public interface GetHelp
{
	Event createEvent();

	void notifyAllInRange(Event event);

	void callEmergency();
}
