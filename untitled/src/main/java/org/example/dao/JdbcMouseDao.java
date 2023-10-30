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
        return null;
    }

    public List<Mouse> getMiceBySize(int length, int width, int height) {
        return null;
    }

    public List<Mouse> getMouseByName(String name) {
        return null;
    }

    public Mouse getMouseById(int id) {
        return null;
    }

    public Mouse updateMouse(int id) {
        return null;
    }

    public void deleteMouse(int id) {

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
