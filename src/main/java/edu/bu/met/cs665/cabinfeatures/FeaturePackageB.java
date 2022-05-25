package edu.bu.met.cs665.cabinfeatures;

/**
 * Class FeaturePackageB.
 */
public class FeaturePackageB implements FeaturePackage {

  /**
   * set bed type.
   * @param type String
   */
  @Override
  public void setBedType(String type) {
    if (!type.isEmpty()) {
      System.out.println("- " + type + " Bed");
    }
  }

  /**
   * install fan feature.
   * @param flag true/false
   */
  @Override
  public void addFan(boolean flag) {
    if (flag) {
      System.out.println("- Fan");
    }
  }

  /**
   * install TV feature.
   * @param flag true/false
   */
  @Override
  public void addTV(boolean flag) {
    if (flag) {
      System.out.println("- TV");
    }
  }

  /**
   * enable internet feature.
   * @param flag true/false
   */
  @Override
  public void enableInternet(boolean flag) {
    if (flag) {
      System.out.println("- Internet enabled");
    }
  }

  /**
   * install kitchenette.
   * @param flag true/false
   */
  @Override
  public void addKitchenette(boolean flag) {
    // not implemented
  }

  /**
   * install outdoor furniture.
   * @param flag true/false
   */
  @Override
  public void addOutdoorFurniture(boolean flag) {
    // not implemented
  }

  /**
   * install deck patio.
   * @param flag true/false
   */
  @Override
  public void addDeckPatio(boolean flag) {
    // not implemented
  }

  /**
   * install hammock feature.
   * @param flag true/false
   */
  @Override
  public void addHammock(boolean flag) {
    if (flag) {
      System.out.println("- Hammock");
    }
  }
}
