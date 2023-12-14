package org.example.dao;

import org.example.exceptions.DaoException;
import org.example.model.Mouse;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class JdbcMouseDao implements MouseDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMouseDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Mouse> getMice(){
        List<Mouse> mice = new ArrayList<Mouse>();
        String sql = "SELECT * FROM mouse;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Mouse newMouse = mapRowToMouse(results);
                mice.add(newMouse);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return mice;
    }

    public List<Mouse> getMiceByBrand(String brand) {
        List<Mouse> mice = new ArrayList<Mouse>();
        String sql = "SELECT * FROM mouse WHERE brand ILIKE ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brand);
            while(results.next()){
                Mouse newMouse = mapRowToMouse(results);
                mice.add(newMouse);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return mice;
    }

    public List<Mouse> getMiceBySize(String size) {
        List<Mouse> mice = new ArrayList<Mouse>();
        String sql = "SELECT * FROM mouse WHERE length*width ";
        switch (size) {
            case "XS":
                sql += "< 6494;";
                break;
            case "S":
                sql += "BETWEEN 6495 AND 8125;";
                break;
            case "M":
                sql += "BETWEEN 8126 AND 8642;";
                break;
            case "L":
                sql += "BETWEEN 8643 AND 9039;";
                break;
            case "XL":
                sql += "> 9040;";
                break;
        }
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                Mouse newMouse = mapRowToMouse(results);
                mice.add(newMouse);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return mice;
    }

    public List<Mouse> getMouseByName(String name) {
        List<Mouse> mice = new ArrayList<Mouse>();
        String sql = "SELECT * FROM mouse WHERE name ILIKE ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
            while(results.next()){
                Mouse newMouse = mapRowToMouse(results);
                mice.add(newMouse);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return mice;
    }

    public Mouse getMouseById(int id) {
        Mouse mouse = null;
        String sql = "SELECT * FROM mouse WHERE mouse_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if(results.next()){
                mouse = mapRowToMouse(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return mouse;
    }

    public Mouse updateMouse(Mouse mouse) {
        Mouse updatedMouse = null;
        String sql = "UPDATE mouse SET brand = ?, name = ?, m_length = ?, m_width = ?, m_height = ?, weight = ?, symmetrical = ?, " +
                "sensor = ?, wireless = ?, max_dpi = ?, polling_rate = ? " +
                "WHERE mouse_id = ?;";
        try{
            int numberOfRows = jdbcTemplate.update(sql, mouse.getBrand(), mouse.getModel(), mouse.getLength(), mouse.getWidth(),
                    mouse.getHeight(), mouse.getWeight(),mouse.isSymmetrical(), mouse.getSensor(), mouse.isWireless(), mouse.getDpi(),
                    mouse.getPollingRate(), mouse.getId());
            if(numberOfRows == 0){
                throw new DaoException("Zero rows affected, expected one");
            } else {
                updatedMouse = getMouseById(mouse.getId());
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return updatedMouse;
    }

    public int deleteMouse(int id) {
        int numberOfRows = 0;
        String sql = "DELETE FROM mouse WHERE mouse_id = ?;";
        try{
            numberOfRows = jdbcTemplate.update(sql);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private Mouse mapRowToMouse(SqlRowSet results) {
        Mouse mouse = new Mouse();
        mouse.setId(results.getInt("mouse_id"));
        mouse.setBrand(results.getString("brand"));
        mouse.setModel(results.getString("name"));
        mouse.setLength(results.getInt("m_length"));
        mouse.setWidth(results.getInt("m_width"));
        mouse.setHeight(results.getInt("m_height"));
        mouse.setWeight(results.getInt("weight"));
        mouse.setShape(results.getBoolean("symmetrical"));
        mouse.setConnectivity(results.getBoolean("wireless"));
        mouse.setSensor(results.getString("sensor"));
        mouse.setDpi(results.getInt("max_dpi"));
        mouse.setPollingRate(results.getInt("polling_rate"));
        return mouse;
    }
}
