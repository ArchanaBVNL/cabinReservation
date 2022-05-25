package edu.bu.met.cs665.validation;

import edu.bu.met.cs665.Customer;
import edu.bu.met.cs665.Reservation;
import java.time.LocalTime;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class TimeValidation extends Abstract Class ValidationDecorator.
 */
public class TimeValidation extends ValidationDecorator {
  // variable of type ReservationValidation
  private ReservationValidation reservationValidation;

  public static final Logger logger = Logger.getLogger(Customer.class);

  /**
   * constructor.
   * @param reservationValidation ReservationValidation
   */
  public TimeValidation(ReservationValidation reservationValidation) {
    this.reservationValidation = reservationValidation;
    logger.setLevel(Level.INFO);
  }

  /**
   * method to validate reservation check-in and check-out time.
   * @param reservation Reservation
   * @param reservationList ArrayList
   * @return ReservationValidation
   */
  @Override
  public ReservationValidation validate(Reservation reservation,
      ArrayList<Reservation> reservationList) {

    // reservation check-in must be 15:00
    LocalTime stdCheckInTime = LocalTime.parse("15:00");
    // reservation check-in must be 11:00
    LocalTime stdCheckOutTime = LocalTime.parse("11:00");
    // customer entered check-in time.
    LocalTime checkInTime = LocalTime.parse(reservation.getCheckInTime());
    // customer entered check-out time.
    LocalTime checkOutTime = LocalTime.parse(reservation.getCheckOutTime());

    // verify if the check-in and check-out time meet the corresponding standard times.
    if (checkInTime.isBefore(stdCheckInTime) || checkOutTime.isAfter(stdCheckOutTime)) {
      logger.info("\nERROR: The allowed Check-In Time is 15:00 PM and "
          + "Check-Out Time is 11:00 AM.");
      this.result = false;
    }
    if (this.result) {
      logger.info("\n- Check-In & Check-Out times selected are valid.");
    }
    return this;
  }

  /**
   * get reservation validation.
   * @return ReservationValidation
   */
  public ReservationValidation getReservationValidation() {
    return reservationValidation;
  }

  /**
   * set reservation validation.
   * @param reservationValidation ReservationValidation
   */
  public void setReservationValidation(ReservationValidation reservationValidation) {
    this.reservationValidation = reservationValidation;
  }
}
