package edu.bu.met.cs665;

/**
 * Class Reservation.
 */
public class Reservation {
  // reservation information
  private int reservationId;
  private int customerId;
  private int cabinId;
  private String startDate;
  private String endDate;
  private String checkInTime;
  private String checkOutTime;
  private String status;

  /**
   * constructor.
   * @param id int
   * @param customerId int
   * @param cabinId int
   * @param startDate String
   * @param endDate String
   * @param checkInTime String
   * @param checkOutTime String
   * @param status String
   */
  public Reservation(int id, int customerId, int cabinId, String startDate,
      String endDate, String checkInTime, String checkOutTime, String status) {
    this.reservationId = id;
    this.customerId = customerId;
    this.cabinId = cabinId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.checkInTime = checkInTime;
    this.checkOutTime = checkOutTime;
    this.status = status;
  }

  /**
   * get reservation id.
   * @return int
   */
  public int getReservationId() {
    return reservationId;
  }

  /**
   * set reservation id.
   * @param id int
   */
  public void setReservationId(int id) {
    this.reservationId = id;
  }

  /**
   * get customer id.
   * @return int
   */
  public int getCustomer() {
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
   * get cabin id.
   * @return int
   */
  public int getCabinId() {
    return cabinId;
  }

  /**
   * set cabin id.
   * @param cabinId int
   */
  public void setCabinId(int cabinId) {
    this.cabinId = cabinId;
  }

  /**
   * get reservation start date.
   * @return String
   */
  public String getStartDate() {
    return startDate;
  }

  /**
   * set reservation start date.
   * @param startDate String
   */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  /**
   * get reservation end date.
   * @return String
   */
  public String getEndDate() {
    return endDate;
  }

  /**
   * set reservation end date.
   * @param endDate String
   */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  /**
   * get check-in time.
   * @return String
   */
  public String getCheckInTime() {
    return checkInTime;
  }

  /**
   * set check-in time.
   * @param checkInTime String
   */
  public void setCheckInTime(String checkInTime) {
    this.checkInTime = checkInTime;
  }

  /**
   * get check-out time.
   * @return String
   */
  public String getCheckOutTime() {
    return checkOutTime;
  }

  /**
   * set check-out time.
   * @param checkOutTime String
   */
  public void setCheckOutTime(String checkOutTime) {
    this.checkOutTime = checkOutTime;
  }

  /**
   * get status.
   * @return String
   */
  public String getStatus() {
    return status;
  }

  /**
   * set status.
   * @param status String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * string version of reservation object.
   * @return String
   */
  @Override
  public String toString() {
    return '\n' + String.valueOf(reservationId) + ';' + customerId + ';'
        + cabinId + ';' + startDate + ';' + endDate + ';'
        + checkInTime + ';' + checkOutTime + ';' + status;
  }

  /**
   * reservation information display.
   * @return String
   */
  public String reservationDetails() {
    return "ReservationId = " + reservationId
        + "\ncustomerId = " + customerId
        + "\ncabinId = " + cabinId
        + "\nstartDate = " + startDate
        + "\nendDate = " + endDate
        + "\ncheckInTime = " + checkInTime
        + "\ncheckOutTime = " + checkOutTime
        + "\nstatus = " + status;
  }
}
