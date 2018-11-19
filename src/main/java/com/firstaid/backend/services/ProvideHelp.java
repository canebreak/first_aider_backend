package com.firstaid.backend.services;

import com.firstaid.backend.Model.Event;

import java.util.List;

public interface ProvideHelp
{
	void acceptHelp(Event event);

	void ignoreHelp(Event event);

	List<Event> findHelpEvents();
}
