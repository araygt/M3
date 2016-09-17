package model;

/**
 * ClassStanding is a representation of all Student Class Standings
 *
 * @author Andrew Ray
 * @version 1.1.0
 * @since 09/16/2016
 */
public enum ClassStanding {
    FR("Freshman", "FR"),
    SO("Sophomore", "SO"),
    JR("Junior", "JR"),
    SR("Senior", "SR");

    private final String standing;
    private final String code;

  /**
   * Constructs a new ClassStanding enum
   */
  ClassStanding(String standing, String code) {
    this.standing = standing;
    this.code = code;
  }

  /** Returns the Standing */
  public String getStanding() { return standing; }

  /** Returns the Code of the Standing */
  public String getCode() { return code; }

  /** Returns the String representation of ClassStanding */
  public String toString() { return code; }
}