package com.firstaid.backend;

import com.firstaid.backend.resource.helper.ResourceHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
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
		String dummy = jdbcTemplate.queryForObject("SELECT first_name FROM users", String.class);
		log.debug("dummy={}", dummy);
	}


	@Test
	public void addUser(){
		String first_name = "Test 4";
		String last_name = "Test 4";
		String password = "Test 4";

		String sql = ResourceHelper.getResourceText("/sql/add_user.sql");
		jdbcTemplate.update(sql,first_name, last_name, password);
	}
	@Test
	public void addRole(){
		String name = "user";
		String role_code = "ROLE_USER";
		String sql = ResourceHelper.getResourceText("/sql/add_role.sql");
		jdbcTemplate.update(sql, name, role_code);
	}
	@Test
	public void addEventType(){
		String name = "car accident";
		String event_code = "CAR_ACCIDENT";
		String sql = ResourceHelper.getResourceText("/sql/add_event_type.sql");
		jdbcTemplate.update(sql, name, event_code);
	}
	@Test
	public void addEvent(){ //THIS TEST WILL FAIL
		String name = "Saobracajna nesreca na autokomandi";
		Point point = new Point(44.753844, 20.453239);
		long user_id = 2;
		long event_type_id = 1;
		String sql = ResourceHelper.getResourceText("/sql/add_event.sql");
		jdbcTemplate.update(sql, name, point, user_id, event_type_id);

		//TODO: Check why this dont work
	}
}
