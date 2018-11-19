package com.firstaid.backend.services;

import com.firstaid.backend.Model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetHelpImpl implements GetHelp
{
	@Override
	public Event createEvent()
	{
		return null;
	}

	@Override
	public void notifyAllInRange(Event event)
	{

	}

	@Override
	public void callEmergency()
	{

	}
}
