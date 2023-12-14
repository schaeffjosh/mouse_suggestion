package org.example.dao;

import org.example.model.Mouse;

import java.util.List;

public interface MouseDao {

    /**
     * Get all mice.
     *
     * @return a list of all mice as objects.
     */
    List<Mouse> getMice();

    /**
     * Get a mouse from the datastore that belongs to the given id.
     * If the id is not found, return null.
     *
     * @param id the mouse id
     * @return a filled out mouse object
     */
    Mouse getMouseById(int id);

    /**
     * Get all mice from the datastore that are similar to the given name.
     * If the name is not found, return null.
     *
     * @param name the mouse name to get from the datastore
     * @return a filled out list of mouse objects
     */
    List<Mouse> getMouseByName(String name);

    /**
     * Get a list of mice from the datastore that are within a certain range of sizes.
     * If no mice match, return null.
     *
     * @param size general size of mouse
     * @return a list of mice matching the size criteria
     */
    List<Mouse> getMiceBySize(String size);

    /**
     * Get all mice from a given brand.
     * If the brand is not found, return null.
     *
     * @param brand the brand to get from the datastore
     * @return a list of mice
     */
    List<Mouse> getMiceByBrand(String brand);

    /**
     * Update a mouse at given id.
     *
     * @param id the mouse id to get from the datastore
     * @return a the updated mouse object
     */
    Mouse updateMouse(Mouse mouse);

    /**
     * Delete a mouse at given id.
     *
     * @param id the mouse id to delete from the datastore
     */
    int deleteMouse(int id);

}
