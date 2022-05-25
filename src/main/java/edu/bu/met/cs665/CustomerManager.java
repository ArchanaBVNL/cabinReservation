package edu.bu.met.cs665;

/**
 * interface CustomerManager.
 */
public interface CustomerManager {
  // method to receive message from Reservation Mediator.
  void receiveMessage(ReservationMediator mediator, String message);

  // method to send reservation request to Reservation Mediator.
  boolean makeReservation(ReservationMediator mediator, Reservation reservation);
}
