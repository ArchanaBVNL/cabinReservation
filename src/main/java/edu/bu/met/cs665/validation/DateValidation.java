package edu.bu.met.cs665.validation;

import edu.bu.met.cs665.Customer;
import edu.bu.met.cs665.Reservation;
import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class DateValidation extends Class ReservationValidation.
 */
public class DateValidation extends ReservationValidation {
  public static final Logger logger = Logger.getLogger(Customer.class);

  /**
   * constructor.
   */
  public DateValidation() {
    logger.setLevel(Level.INFO);
  }

  /**
   * method to validate a reservation by date.
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

    // check if customer entered endDate is greater than startDate
    if (startDate.compareTo(endDate) > 0) {
      logger.info("\nERROR: Start Date is after End Date!");
      this.result = false;
    } else if (startDate.compareTo(endDate) == 0) {
      // check if customer entered starDate and endDate are same.
      logger.info("\nERROR: Start Date and End Date are same!");
      this.result = false;
    } else {
      // check if the cabin is available for requested startDate and endDate.
      // compare the new reservation with all the existing reservations.
      for (Reservation r : reservationList) {
        LocalDate compStartDate = LocalDate.parse(r.getStartDate());
        LocalDate compEndDate = LocalDate.parse(r.getEndDate());

        // get the 'dd' from the date.
        int s2 = compStartDate.getDayOfMonth();
        int e2 = compEndDate.getDayOfMonth();
        int s1 = startDate.getDayOfMonth();
        int e1 = endDate.getDayOfMonth();

        // if the new reservation request is for an already booked cabin then display error.
        if (reservation.getCabinId() == r.getCabinId()) {
          // Assuming a cabin can be reserved only for two days.
          // Eg: new reservation, startDate = 2021-03-10, endDate = 2021-03-12.
          // Check for existing reservations with start date in range - 09 to 13.
          // and end date in range - 10 to 14.
          if (((s1 - 1) <= s2 && s2 <= (s1 + 3)) || ((e1 - 2) <= e2 && e2 <= (e1 + 2))) {
            logger.info("\nERROR: Cabin not available on selected dates!");
            this.result = false;
          }
        }
      }
    }
    if (this.result) {
      logger.info("\n- Cabin available on selected valid dates.");
    }
    return this;
  }
}
