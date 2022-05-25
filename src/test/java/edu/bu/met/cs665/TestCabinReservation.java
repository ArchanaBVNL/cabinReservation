package edu.bu.met.cs665;

import edu.bu.met.cs665.cabin.BasicCabin;
import edu.bu.met.cs665.cabin.Cabin;
import edu.bu.met.cs665.cabin.IntermediateCabin;
import edu.bu.met.cs665.cabin.LuxuryCabin;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test Class.
 */
public class TestCabinReservation {

  public static final Logger logger = Logger.getLogger(TestCabinReservation.class);

  /**
   * setup data files.
   * @throws IOException Exception
   */
  @BeforeClass
  public static void setUpOnce() throws IOException {

    String CUSTOMER_FILE = "src/main/java/edu/bu/met/cs665/data/customer.dat";
    String RESERVATION_FILE = "src/main/java/edu/bu/met/cs665/data/reservation.dat";
    BufferedWriter bw;

    File dataFile = new File(CUSTOMER_FILE);
    if(dataFile.exists()){
      boolean res = dataFile.delete();
    }
    // If data file already exits, delete to create a new one
    if(dataFile.createNewFile()) {
      bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dataFile, true),
          Charset.defaultCharset()));
      // add first line to data file
      bw.write("30;tom;hope;california blvd;20034;284-183-9288;tom@pqr.com;ADGC849;CA-45459");
      bw.close();
    }

    dataFile = new File(RESERVATION_FILE);
    if(dataFile.exists()){
      boolean res = dataFile.delete();
    }
    // If data file already exits, delete to create a new one
    if(dataFile.createNewFile()) {
      bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dataFile, true),
          Charset.defaultCharset()));
      // add first line to data file
      bw.write("12;30;3;2020-12-20;2020-12-22;15:00;11:00;confirmed");
      bw.close();
    }
  }

  /**
   * initial setup
   * @throws Exception Exception
   */
  @Before
  public void setUp() throws Exception {
    logger.setLevel(Level.INFO);
  }

  /**
   * method to test customer sending a reservation request and mediator confirming the same.
   */
  @Test
  public void testMakeReservation(){

    System.out.println("\n**** testMakeReservation() ****");

    // initialize customer information
    Customer customer = new Customer(24,"mary","little",
        "boston way", "45002","342-183-3278","mary@abc.com",
        "ABC-231-456", "MA-4567");
    // create a reservation mediator
    ReservationMediator reservationMediator = new ReservationManager();

    // create a cabin object
    Cabin cabin = new BasicCabin(1);

    // configure cabin features
    cabin.configureFeaturePackage();

    // create reservation information
    Reservation reservation = new Reservation(23, customer.getCustomerId(), cabin.getNumber(),
        "2021-03-12", "2021-03-14", "15:00", "11:00",
        "new");

    // customer sends a reservation request.
    boolean flag = customer.makeReservation(reservationMediator, reservation);

    // assert the reservation request is processed and confirmed.
    Assert.assertTrue(flag);

    double cost = cabin.getPricePerNight() * 2;
    logger.info("\nTotal Cost = $" + cost);
  }

  /**
   * test sending a message a customer from a mediator.
   */
  @Test
  public void testMessageCustomer() {
    System.out.println("\n**** testMessageCustomer() ****");
    Customer customer = new Customer(33,"kelly","samson",
        "illinois av", "60600","345-234-3278","kelly@xyz.com",
        "PQR231456", "IL-7867");
    ReservationMediator reservationMediator = new ReservationManager();

    // reservation mediator sends a message to a customer
    reservationMediator.messageCustomer(customer,
          "\nHi " + customer.getFirstName()
              + "!, DEAL - Save up to 50% on your next Cabin Rental!");
  }

  /**
   * method to test if requested start date and end date is available for reservation.
   */
  @Test
  public void testDateAvailability() {
    System.out.println("\n**** testDateAvailability() ****");
    Customer customer = new Customer(133,"greg","thomas",
        "dakota st", "45678","333-444-2222","greg@abc.com",
        "FGG945454", "AL-34343");
    ReservationMediator reservationMediator = new ReservationManager();

    Cabin cabin = new BasicCabin(3);

    cabin.configureFeaturePackage();

    // Cabin 3 is already booked from 2020-12-20 to 2020-12-22, therefore unavailable.
    Reservation reservation = new Reservation(110, customer.getCustomerId(), cabin.getNumber(),
        "2020-12-19", "2020-12-21", "15:00", "11:00",
        "new");

    boolean flag = customer.makeReservation(reservationMediator, reservation);

    // assert the reservation request was no successful
    Assert.assertFalse(flag);
  }

  /**
   * method to test if requested reservation date is valid.
   */
  @Test
  public void testDateValidation() {
    System.out.println("\n**** testDateValidation ****");
    Customer customer = new Customer(41,"harry","cooper",
        "portland ln", "97004","654-234-3278","harry@xyz.com",
        "PQ5466777", "OR-45467");
    ReservationMediator reservationMediator = new ReservationManager();

    Cabin cabin = new LuxuryCabin(4);

    cabin.configureFeaturePackage();

    // Error: end date comes before start date.
    Reservation reservation = new Reservation(44, customer.getCustomerId(), cabin.getNumber(),
        "2021-12-04", "2021-12-01", "15:00", "11:00",
        "new");

    boolean flag = customer.makeReservation(reservationMediator, reservation);

    // assert on invalid date.
    Assert.assertFalse(flag);
  }

  /**
   * method to test time validation of a reservation.
   */
  @Test
  public void testTimeValidation() {
    System.out.println("\n**** testTimeValidation() ****");
    Customer customer = new Customer(55,"jerry","miller",
        "austin blvd", "56004","234-156-3278","austin@dfg.com",
        "DDG778944", "TX-454567");
    ReservationMediator reservationMediator = new ReservationManager();

    Cabin cabin = new IntermediateCabin(5);

    cabin.configureFeaturePackage();

    // requested check-in time is 10:00 which is not valid, valid check in time is 15:00
    Reservation reservation = new Reservation(67, customer.getCustomerId(), cabin.getNumber(),
        "2021-01-10", "2021-01-12", "10:00", "11:00",
        "new");

    boolean flag = customer.makeReservation(reservationMediator, reservation);

    // assert on invalid check-in time
    Assert.assertFalse(flag);
  }

  /**
   * method to validate duration of a reservation.
   */
  @Test
  public void testDurationValidation() {
    System.out.println("\n**** testDurationValidation() ****");
    Customer customer = new Customer(66,"harvey","williams",
        "orlando ln", "34567","123-234-9999","harvey@xyz.com",
        "YH3433353", "FL-34456");
    ReservationMediator reservationMediator = new ReservationManager();

    Cabin cabin = new LuxuryCabin(8);

    cabin.configureFeaturePackage();

    // reservation requested for 4 days, valid reservation is for two days.
    Reservation reservation = new Reservation(121, customer.getCustomerId(), cabin.getNumber(),
        "2022-01-04", "2022-01-09", "15:00", "11:00",
        "new");

    boolean flag = customer.makeReservation(reservationMediator, reservation);

    // assert on incorrect duration
    Assert.assertFalse(flag);
  }

  /**
   * test configuration of cabin feature package.
   */
  @Test
  public void testConfigureFeaturePackage() {
    System.out.println("\n**** testConfigurePackage() ****");
    Cabin cabin = new LuxuryCabin(15);
    cabin.configureFeaturePackage();
  }
}