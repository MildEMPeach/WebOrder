package org.mildempeach;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "password VARCHAR(100) NOT NULL)");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS instruments (" +
                "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "price DECIMAL(10,2) NOT NULL," +
                "weight DECIMAL(10,2) NOT NULL)");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS carts (" +
                "userid INT NOT NULL," +
                "instrumentid INT NOT NULL," +
                "instrumentname VARCHAR(100) NOT NULL," +
                "number INT NOT NULL," +
                "price DECIMAL(10,2) NOT NULL," +
                "weight DECIMAL(10,2) NOT NULL)");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS bills (" +
                "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "userid INT NOT NULL," +
                "amount DECIMAL(10,2) NOT NULL," +
                "weight DECIMAL(10,2) NOT NULL)");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS records (" +
                "billid INT NOT NULL," +
                "userid INT NOT NULL," +
                "instrumentid INT NOT NULL," +
                "instrumentname VARCHAR(100) NOT NULL," +
                "number INT NOT NULL)");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS reviews (" +
                "instrumentid INT NOT NULL," +
                "userid INT NOT NULL," +
                "comment VARCHAR(1000) NOT NULL)");
    }

}
