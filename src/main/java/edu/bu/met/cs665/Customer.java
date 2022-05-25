package edu.bu.met.cs665;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class Customer implements interface CustomerManager.
 */
public class Customer implements CustomerManager {
  // customer information
  private int customerId;
  private String firstName;
  private String lastName;
  private String streetAddress;
  private String zipcode;
  private String phoneNumber;
  private String email;
  private String licenseId;
  private String carLicensePlate;
  // Customer is connected to a ReservationMediator
  private ReservationMediator reservationMediator;

  public static final Logger logger = Logger.getLogger(Customer.class);

  /**
   * constructor.
   * @param customerId int
   * @param firstName String
   * @param lastName String
   * @param streetAddress String
   * @param zipcode String
   * @param phoneNumber String
   * @param email String
   * @param licenseId String
   * @param carLicensePlate String
   */
  public Customer(int customerId, String firstName, String lastName,
      String streetAddress, String zipcode, String phoneNumber, String email, String licenseId,
      String carLicensePlate) {
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.zipcode = zipcode;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.licenseId = licenseId;
    this.carLicensePlate = carLicensePlate;
    logger.setLevel(Level.INFO);
  }

  /**
   * Method used by a Customer to send a reservation request to ReservationMediator.
   * @param mediator ReservationMediator
   * @param reservation Reservation
   * @return boolean
   */
  @Override
  public boolean makeReservation(ReservationMediator mediator, Reservation reservation) {
    // assign mediator
    this.reservationMediator = mediator;
    // submit reservation request to reservation mediator
    return this.reservationMediator.getRequest(reservation, this);
  }

  /**
   * receive messages from mediator.
   * @param mediator ReservationMediator
   * @param message String
   */
  @Override
  public void receiveMessage(ReservationMediator mediator, String message) {
    logger.info(message);
  }

  /**
   * get customer first name.
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set customer first name.
   * @param firstName String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * get customer last name.
   * @return String
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set customer last name.
   * @param lastName String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * get street address.
   * @return String
   */
  public String getStreetAddress() {
    return streetAddress;
  }

  /**
   * set street address.
   * @param streetAddress String
   */
  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  /**
   * get zipcode.
   * @return String
   */
  public String getZipcode() {
    return zipcode;
  }

  /**
   * set zipcode.
   * @param zipcode String
   */
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  /**
   * get phone number.
   * @return String
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * set phone number.
   * @param phoneNumber String
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * get email.
   * @return String
   */
  public String getEmail() {
    return email;
  }

  /**
   * set email.
   * @param email String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * get license id.
   * @return String
   */
  public String getLicenseId() {
    return licenseId;
  }

  /**
   * set license id.
   * @param licenseId String
   */
  public void setLicenseId(String licenseId) {
    this.licenseId = licenseId;
  }

  /**
   * get car license plate.
   * @return String
   */
  public String getCarLicensePlate() {
    return carLicensePlate;
  }

  /**
   * set car license plate.
   * @param carLicensePlate String
   */
  public void setCarLicensePlate(String carLicensePlate) {
    this.carLicensePlate = carLicensePlate;
  }

  /**
   * get Reservation Mediator.
   * @return ReservationMediator
   */
  public ReservationMediator getReservationMediator() {
    return reservationMediator;
  }

  /**
   * set Reservation Mediator.
   * @param reservationMediator ReservationMediator
   */
  public void setReservationMediator(ReservationMediator reservationMediator) {
    this.reservationMediator = reservationMediator;
  }

  /**
   * get customer id.
   * @return int
   */
  public int getCustomerId() {
    return customerId;
  }

  /**
   * set customer id.
   * @param customerId int
   */
  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  /**
   * customer object info.
   * @return String
   */
  @Override
  public String toString() {
    return "\n" + customerId + ';' + firstName + ';' + lastName + ';' + streetAddress + ';'
        + zipcode + ';' + phoneNumber + ';' + email + ';' + licenseId + ';' + carLicensePlate;
  }

  /**
   * compare customer objects.
   * @param c Customer
   * @return boolean
   */
  public boolean compareTo(Customer c) {
    return this.customerId == c.getCustomerId() && this.firstName.equals(c.firstName)
        && this.lastName.equals(c.lastName) && this.streetAddress.equals(c.streetAddress)
        && this.zipcode.equals(c.zipcode) && this.phoneNumber.equals(c.phoneNumber)
        && this.email.equals(c.email) && this.licenseId.equals(c.licenseId)
        && this.carLicensePlate.equals(c.carLicensePlate);
  }
}
