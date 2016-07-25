package com.zdatainc.WebController;

import com.google.gson.Gson;
import com.zdatainc.Predictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by demo on 7/25/16.
 */
@Controller
@RequestMapping("/data")
public class DataController {
    private DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource ds) {
        this.datasource = ds;
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @RequestMapping(params="gender", method= RequestMethod.GET)
    public @ResponseBody String data(@RequestParam("gender") String gender) {
        String returnValue = "";
        if (gender.equals("male")) {
            List<Predictions> male = jdbcTemplate.query("SELECT my_id, field_0, field_9, target FROM predictions WHERE field_9 = '1.0'", (rs, rowNum) -> new Predictions(rs.getInt("my_id"), rs.getDouble("field_0"), rs.getDouble("field_9"), rs.getDouble("target")));
            returnValue = new Gson().toJson(male);
        }
        if (gender.equals("female")) {
            List<Predictions> female = jdbcTemplate.query("SELECT my_id, field_0, field_9, target FROM predictions WHERE field_9 = '0.0'", (rs, rowNum) -> new Predictions(rs.getInt("my_id"), rs.getDouble("field_0"), rs.getDouble("field_9"), rs.getDouble("target")));
            returnValue = new Gson().toJson(female);
        }
        return returnValue;
    }
}
