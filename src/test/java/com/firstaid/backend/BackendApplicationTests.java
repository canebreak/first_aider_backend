package com.firstaid.backend;

import com.firstaid.backend.Model.LongLat;
import com.firstaid.backend.resource.helper.ResourceHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    public void addUser() {
        String first_name = "Test 5";
        String last_name = "Test 5";
        String password = "Test 5";

        String sql = ResourceHelper.getResourceText("/sql/add_user.sql");
        jdbcTemplate.update(sql, first_name, last_name, password);
    }

    @Test
    public void addRole() {
        String name = "guest";
        String role_code = "ROLE_GUEST";
        String sql = ResourceHelper.getResourceText("/sql/add_role.sql");
        jdbcTemplate.update(sql, name, role_code);
    }

    @Test
    public void addEventType() {
        String name = "dead body";
        String event_code = "DEAD_BODY";
        String sql = ResourceHelper.getResourceText("/sql/add_event_type.sql");
        jdbcTemplate.update(sql, name, event_code);
    }

    @Test
    public void addEvent() { //THIS TEST WILL FAIL
        String name = "Saobracajna nesreca na autokomandi";
        Point point = new Point(44.753844, 20.453239);
        long user_id = 2;
        long event_type_id = 1;
        String sql = ResourceHelper.getResourceText("/sql/add_event.sql");
        jdbcTemplate.update(sql, name, point, user_id, event_type_id);
    }

    @Test
    public void getUsersInRadius() {
        LongLat userLocation = new LongLat();
        userLocation.setLatitude(44.210000);
        userLocation.setLongitude(21.210000);

        List<LongLat> longLatList = new ArrayList<>();

        longLatList.add(new LongLat(44.200010, 21.200090));
        longLatList.add(new LongLat(44.200210, 21.200290));
        longLatList.add(new LongLat(44.200200, 21.200200));
        longLatList.add(new LongLat(44.200300, 21.200300));
        longLatList.add(new LongLat(44.210300, 21.210300));
        longLatList.add(new LongLat(44.200123, 21.200123));
        longLatList.add(new LongLat(43.200123, 21.200123));

        //2km
        double lat = 0.018018;
        double lon = 0.025000;

        List<LongLat> res = new ArrayList<>();
        for (int i = 0; i < longLatList.size(); i++) {
            if (longLatList.get(i).getLatitude() < userLocation.getLatitude() + lat &&
                    (longLatList.get(i).getLatitude() > userLocation.getLatitude() - lat)) {
                if (longLatList.get(i).getLongitude() < userLocation.getLongitude() + lon &&
                        (longLatList.get(i).getLongitude() > userLocation.getLongitude() - lon)) {
                    res.add(longLatList.get(i));
                }
            }
        }

        System.out.println(res);


    }
}
