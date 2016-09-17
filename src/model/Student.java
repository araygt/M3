package model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by robertwaters on 8/12/16.
 *
 * Represents a single student in the system
 *
 * Information Holder
 */
public class Student {
    /**
     * Properties are a way of binding data under the JavaBeans specification.
     *
     * See the article at: http://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
     * for more details.
     */
    private final StringProperty _name = new SimpleStringProperty();
    private final StringProperty _major = new SimpleStringProperty();
    private final StringProperty _standing = new SimpleStringProperty();

    /* **********************
     * Getters and setters for properties
     */
    public String getName() { return _name.get(); }
    public void setName(String name) { _name.set(name); }

    public String getMajor() { return _major.get(); }
    public void setMajor(String major) { _major.set(major); }

    public String getStanding() { return _standing.get(); }
    public void setStanding(String standing) { _standing.set(standing); }

    /**
     * Make a new student
     * @param name      the student's name
     * @param major     the student's major
     */
    public Student(String name, String major) {
        _name.set(name);
        _major.set(major);
        _standing.set(ClassStanding.FR.getStanding());
    }

    /**
     * Make a new student with Standing
     * @param name      the student's name
     * @param major     the student's major
     * @param standing  the student's standing
     */
    public Student(String name, String major, String standing) {
        _name.set(name);
        _major.set(major);
        _standing.set(standing);
    }

    /**
     * No param constructor -- DO NOT CALL NORMALLY
     * This constructor only for GUI use in edit/new student dialog
     */
    public Student() {
        _name.set("enter new name");
        _major.set("enter new major");
        _standing.set("enter new standing");
    }

    /**
     *
     * @return the display string representation
     */
    public String toString() {
        return _name.get() + " "
             + _major.get() + " "
             + _standing.get();
    }

}
