package edu.bu.met.cs665.cabin;

import edu.bu.met.cs665.cabinfeatures.FeaturePackageC;

/**
 * Subclass LuxuryCabin of Superclass Cabin.
 */
public class LuxuryCabin extends Cabin {

  /**
   * constructor.
   * @param number int
   */
  public LuxuryCabin(int number) {
    super(number, "Luxury Cabin", new FeaturePackageC(), 250, 8);
  }

  /**
   * Configure the features of the Luxury Cabin.
   */
  @Override
  public void configureFeaturePackage() {
    System.out.println("The Luxury Cabin Feature List: ");
    // Call methods in FeaturePackageC
    this.featurePackage = new FeaturePackageC();
    this.featurePackage.setBedType("King");
    this.featurePackage.setBedType("King");
    this.featurePackage.setBedType("Sofa Bed");
    this.featurePackage.addFan(true);
    this.featurePackage.addTV(true);
    this.featurePackage.enableInternet(true);
    this.featurePackage.addHammock(true);
    this.featurePackage.addKitchenette(true);
    this.featurePackage.addOutdoorFurniture(true);
    this.featurePackage.addDeckPatio(true);
  }
}
