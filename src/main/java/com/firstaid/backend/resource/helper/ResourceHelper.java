package com.firstaid.backend.resource.helper;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

//import java.io.InputStreamReader;

public class ResourceHelper
{
	private ResourceHelper()
	{

	}

	public static String getResourceText(String resourceUrl)
	{
		try
		{
			return IOUtils.toString(ResourceHelper.class.getResourceAsStream(resourceUrl), StandardCharsets.UTF_8);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(String.format("There is no resource file %s", resourceUrl));
		}
	}
}