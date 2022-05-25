package edu.bu.met.cs665;

/**
 * interface ReservationMediator.
 */
public interface ReservationMediator {
  // register a new customer into ReservationMediator
  void register(Customer customer);

  // send message to a customer
  void messageCustomer(Customer customer, String message);

  // get customer request
  boolean getRequest(Reservation reservation, Customer customer);
}
