package com.medical.doctor.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;

public class ExpertizedExtractor implements ResultSetExtractor<Map<Integer, String>> {

    @Override
    public Map<Integer, String> extractData(ResultSet rs) throws SQLException {

        Map<Integer, String> expertizedMap = new HashMap<>();
        while (rs.next()) {

            expertizedMap.put(rs.getInt("id"), rs.getString("expertise"));
        }
System.out.println(expertizedMap.size());
        return expertizedMap;

    }

}
