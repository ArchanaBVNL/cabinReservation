package edu.bu.met.cs665.cabin;

import edu.bu.met.cs665.cabinfeatures.FeaturePackageA;

/**
 * Subclass BasicCabin for superclass Cabin.
 */
public class BasicCabin extends Cabin {

  /**
   * Constructor.
   * @param number int
   */
  public BasicCabin(int number) {
    // initialize basic cabin.
    super(number, "Basic Cabin", new FeaturePackageA(), 60, 4);
  }

  /**
   * Configure the features of the Basic Cabin.
   */
  @Override
  public void configureFeaturePackage() {
    System.out.println("The Basic Cabin Feature List: ");
    // Call methods in FeaturePackageA
    this.featurePackage = new FeaturePackageA();
    this.featurePackage.setBedType("Queen");
    this.featurePackage.addFan(true);
    this.featurePackage.addTV(true);
    this.featurePackage.enableInternet(true);
  }
}
