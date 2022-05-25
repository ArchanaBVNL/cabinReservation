package edu.bu.met.cs665.cabin;

import edu.bu.met.cs665.cabinfeatures.FeaturePackageB;

/**
 * Subclass IntermediateCabin for superclass Cabin.
 */
public class IntermediateCabin extends Cabin {

  /**
   * constructor.
   * @param number int
   */
  public IntermediateCabin(int number) {
    super(number, "Intermediate Cabin", new FeaturePackageB(), 150, 6);
  }

  /**
   * Configure the features of the Intermediate Cabin.
   */
  @Override
  public void configureFeaturePackage() {
    System.out.println("The Intermediate Cabin Feature List: ");
    // Call methods in FeaturePackageB
    this.featurePackage = new FeaturePackageB();
    this.featurePackage.setBedType("King");
    this.featurePackage.setBedType("Queen");
    this.featurePackage.addFan(true);
    this.featurePackage.addTV(true);
    this.featurePackage.enableInternet(true);
    this.featurePackage.addHammock(true);
  }
}
