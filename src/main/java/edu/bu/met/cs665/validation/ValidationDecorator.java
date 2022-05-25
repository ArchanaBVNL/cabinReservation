package edu.bu.met.cs665.validation;

import edu.bu.met.cs665.Reservation;
import java.util.ArrayList;

/**
 * abstract class ValidationDecorator.
 */
public abstract class ValidationDecorator extends ReservationValidation {
  // abstract method to validate a requested reservation.
  public abstract ReservationValidation validate(Reservation reservation,
      ArrayList<Reservation> reservationList);
}
