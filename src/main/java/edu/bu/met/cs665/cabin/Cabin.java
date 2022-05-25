package edu.bu.met.cs665.cabin;

import edu.bu.met.cs665.cabinfeatures.FeaturePackage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Abstract Class Cabin.
 */
public abstract class Cabin {
  // cabin information
  protected int number;
  protected String type;
  protected FeaturePackage featurePackage;
  protected double pricePerNight;
  protected int occupancy;

  /**
   * constructor.
   * @param number int
   * @param type String
   * @param featurePackage FeaturePackage
   * @param pricePerNight double
   * @param occupancy occupancy
   */
  public Cabin(int number, String type, FeaturePackage featurePackage, double pricePerNight,
      int occupancy) {
    this.number = number;
    this.type = type;
    this.featurePackage = featurePackage;
    this.pricePerNight = pricePerNight;
    this.occupancy = occupancy;
  }

  /**
   * abstract method - configureFeaturePackage().
   */
  public abstract void configureFeaturePackage();

  /**
   * get cabin number.
   * @return int
   */
  public int getNumber() {
    return number;
  }

  /**
   * set cabin number.
   * @param number int
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * get cabin type.
   * @return String
   */
  public String getType() {
    return type;
  }

  /**
   * set cabin type.
   * @param type String
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * get FeaturePackage.
   * @return FeaturePackage
   */
  public FeaturePackage getFeaturePackage() {
    return featurePackage;
  }

  /**
   * set FeaturePackage.
   * @param featurePackage FeaturePackage
   */
  public void setFeaturePackage(FeaturePackage featurePackage) {
    this.featurePackage = featurePackage;
  }

  /**
   * get cabin price per night.
   * @return double
   */
  public double getPricePerNight() {
    return pricePerNight;
  }

  /**
   * set cabin price per night.
   * @param pricePerNight double
   */
  public void setPricePerNight(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  /**
   * get cabin occupancy.
   * @return int
   */
  public int getOccupancy() {
    return occupancy;
  }

  /**
   * set cabin occupancy.
   * @param occupancy int
   */
  public void setOccupancy(int occupancy) {
    this.occupancy = occupancy;
  }

  /**
   * Cabin object toString.
   * @return String
   */
  @Override
  public String toString() {
    return '\n' + String.valueOf(number) + ';' + type + ';'
        + featurePackage.getClass().getSimpleName()
        + ';' + pricePerNight + ';' + occupancy;
  }
}
