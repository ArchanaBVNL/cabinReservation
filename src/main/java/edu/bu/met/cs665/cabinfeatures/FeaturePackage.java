package edu.bu.met.cs665.cabinfeatures;

/**
 * Interface FeaturePackage.
 */
public interface FeaturePackage {
  // methods to add various features for a Cabin.
  void setBedType(String type);

  void addFan(boolean flag);

  void addTV(boolean flag);

  void enableInternet(boolean flag);

  void addKitchenette(boolean flag);

  void addOutdoorFurniture(boolean flag);

  void addDeckPatio(boolean flag);

  void addHammock(boolean flag);
}
