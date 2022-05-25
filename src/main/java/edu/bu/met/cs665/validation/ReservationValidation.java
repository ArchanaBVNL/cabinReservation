package edu.bu.met.cs665.validation;

import edu.bu.met.cs665.Reservation;
import java.util.ArrayList;

/**
 * Abstract Class ReservationValidation.
 */
public abstract class ReservationValidation {

  // variable to check if reservation is valid or invalid.
  public boolean result;

  /**
   * constructor.
   */
  public ReservationValidation() {
    this.result = true;
  }

  /**
   * abstract method to validate requested reservation.
   * @param reservation Reservation
   * @param reservationList ArrayList
   * @return ReservationValidation
   */
  public abstract ReservationValidation validate(Reservation reservation,
      ArrayList<Reservation> reservationList);
}
