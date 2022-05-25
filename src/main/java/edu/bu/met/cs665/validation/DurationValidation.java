package edu.bu.met.cs665.validation;

import edu.bu.met.cs665.Customer;
import edu.bu.met.cs665.Reservation;
import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Subclass DurationValidation extends Abstract Class ValidationDecorator.
 */
public class DurationValidation extends ValidationDecorator {

  // variable of type ReservationValidation
  private ReservationValidation reservationValidation;

  public static final Logger logger = Logger.getLogger(Customer.class);

  /**
   * constructor to set ReservationValidation variable.
   * @param reservationValidation ReservationValidation
   */
  public DurationValidation(ReservationValidation reservationValidation) {
    this.reservationValidation = reservationValidation;
    logger.setLevel(Level.INFO);
  }

  /**
   * validate number of days chosen for reservation.
   * @param reservation Reservation
   * @param reservationList ArrayList
   * @return ReservationValidation
   */
  @Override
  public ReservationValidation validate(Reservation reservation,
      ArrayList<Reservation> reservationList) {
    // reservation start date
    LocalDate startDate = LocalDate.parse(reservation.getStartDate());
    // reservation end date
    LocalDate endDate = LocalDate.parse(reservation.getEndDate());

    if (startDate.plusDays(2).compareTo(endDate) != 0) {
      logger.info("\nERROR: The cabin can be reserved for two days only.");
      this.result = false;
    }
    if (this.result) {
      logger.info("\n- Number of days selected is valid.");
    }
    return this;
  }

  public ReservationValidation getReservationValidation() {
    return reservationValidation;
  }

  public void setReservationValidation(ReservationValidation reservationValidation) {
    this.reservationValidation = reservationValidation;
  }
}
