package com.firstaid.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Test
	public void contextLoads() {
	}

	@Test
	public void checkDatabaseConnectionTest()
	{
		log.debug("Starting connection");
		String dummy = jdbcTemplate.queryForObject("SELECT dummy FROM dual", String.class);
		log.debug("dummy={}", dummy);

	}

}
