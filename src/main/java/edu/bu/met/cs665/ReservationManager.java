package edu.bu.met.cs665;

import edu.bu.met.cs665.validation.DateValidation;
import edu.bu.met.cs665.validation.DurationValidation;
import edu.bu.met.cs665.validation.ReservationValidation;
import edu.bu.met.cs665.validation.TimeValidation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Class ReservationManager implements interface ReservationMediator.
 */
public class ReservationManager implements ReservationMediator {

  private ArrayList<Customer> customerList = new ArrayList<>();
  private ArrayList<Reservation> reservationList = new ArrayList<>();
  private ReservationValidation reservationValidation;
  private static final String customerFile = "src/main/java/edu/bu/met/cs665/data/customer.dat";
  private static final String reservationFile
      = "src/main/java/edu/bu/met/cs665/data/reservation.dat";
  public static final Logger logger = Logger.getLogger(Customer.class);

  /**
   * constructor.
   */
  public ReservationManager() {
    logger.setLevel(Level.INFO);

    // load existing customer information to customerList.
    try {
      BufferedReader br
          = new BufferedReader(new InputStreamReader(
              new FileInputStream(customerFile), Charset.defaultCharset()));

      String line;
      // read each line of the file
      while ((line = br.readLine()) != null) {
        // split each line into words with delimiter as ';'
        String[] info = line.split(";");
        Customer customer = new Customer(Integer.parseInt(info[0]), info[1], info[2], info[3],
            info[4], info[5], info[6], info[7], info[8]);
        customerList.add(customer);
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // load existing reservation information to reservationList.
    try {
      BufferedReader br1 = new BufferedReader(
          new InputStreamReader(new FileInputStream(reservationFile), Charset.defaultCharset()));

      String line;
      // read each line of the file
      while ((line = br1.readLine()) != null) {
        // split each line into words with delimiter as ';'
        String[] info = line.split(";");

        reservationList.add(new Reservation(Integer.parseInt(info[0]),
            Integer.parseInt(info[1]), Integer.parseInt(info[2]), info[3], info[4], info[5],
            info[6], info[7]));
      }
      br1.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * method to register a new customer.
   * @param customer Customer
   */
  @Override
  public void register(Customer customer) {
    // write new customer information into customer.dat file
    try {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(customerFile, true), Charset.defaultCharset()));

      String line = customer.toString();
      bw.write(line);
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * method to send a message to a customer.
   * @param customer Customer
   * @param message String
   */
  @Override
  public void messageCustomer(Customer customer, String message) {
    // message sent to the customer
    customer.receiveMessage(this, message);
  }

  /**
   * method to get reservation request from a customer.
   * @param reservation Reservation
   * @param customer Customer
   * @return boolean
   */
  @Override
  public boolean getRequest(Reservation reservation, Customer customer) {
    logger.info("\nReservation Request received from CustomerId " + customer.getCustomerId());
    logger.info("\nValidating Reservation Request...");
    boolean found = false;

    // check if the reservation request is valid
    if (requestValidation(reservation)) {
      // if valid, set reservation status to confirmed
      reservation.setStatus("Confirmed");
      // if a new customer then update customer.dat
      for (Customer c : this.customerList) {
        if (c.compareTo(customer)) {
          found = true;
          break;
        }
      }
      if (!found) {
        register(customer);
      }

      // if new reservation request then update reservationl.dat
      found = false;
      for (Reservation r : this.reservationList) {
        if (r.getReservationId() == reservation.getReservationId()) {
          found = true;
          break;
        }
      }
      if (!found) {
        try {
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(reservationFile, true), Charset.defaultCharset()));
          String line = reservation.toString();
          bw.write(line);
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      // send reservation confirmation to the customer
      messageCustomer(customer, "\nReservation request confirmed. Reservation details:\n"
          + reservation.reservationDetails());
      return true;
    }
    return false;
  }

  /**
   * method to validate a reservation request.
   * @param reservation Reservation
   * @return boolean
   */
  public boolean requestValidation(Reservation reservation) {

    // validate reservation start date and end date
    this.reservationValidation = new DateValidation();
    this.reservationValidation = this.reservationValidation.validate(reservation, reservationList);
    // if valid, next validate check-in time and check-out time
    if (this.reservationValidation.result) {
      TimeValidation validateTime = new TimeValidation(this.reservationValidation);
      // if valid, finally check if reservation duration is two days
      if ((this.reservationValidation = validateTime
          .validate(reservation, reservationList)).result) {
        DurationValidation validateDuration = new DurationValidation(this.reservationValidation);
        return (this.reservationValidation = validateDuration
            .validate(reservation, reservationList)).result;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * get customer list.
   * @return ArrayList
   */
  public ArrayList<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * set customer list.
   * @param customerList ArrayList
   */
  public void setCustomerList(ArrayList<Customer> customerList) {
    this.customerList = customerList;
  }

  /**
   * get reservation list.
   * @return ArrayList
   */
  public ArrayList<Reservation> getReservationList() {
    return reservationList;
  }

  /**
   * set reservation List.
   * @param reservationList ArrayList
   */
  public void setReservationList(ArrayList<Reservation> reservationList) {
    this.reservationList = reservationList;
  }

  /**
   * get reservation list.
   * @return ReservationValidation.
   */
  public ReservationValidation getReservationValidation() {
    return reservationValidation;
  }

  /**
   * set reservation list.
   * @param reservationValidation ReservationValidation
   */
  public void setReservationValidation(ReservationValidation reservationValidation) {
    this.reservationValidation = reservationValidation;
  }
}
