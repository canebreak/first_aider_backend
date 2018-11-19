package com.firstaid.backend.services;

import com.firstaid.backend.Model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProvideHelpImpl implements ProvideHelp
{
	@Override
	public void acceptHelp(Event event)
	{

	}

	@Override
	public void ignoreHelp(Event event)
	{

	}

	@Override
	public List<Event> findHelpEvents()
	{
		return null;
	}
}
