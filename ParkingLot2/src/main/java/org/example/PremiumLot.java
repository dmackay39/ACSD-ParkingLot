package org.example;

public class PremiumLot implements ParkingLot {

    @Override
    public int calculateFee(Ticket ticket) {
        int hourlyFee = 4;

        int days = ticket.getDays();
        int hours = ticket.getHours();
        int minutes = ticket.getMinutes();

        int bill = 0;
// ToDo:  Use TDD to Implement this function
//  You will need to mock the Ticket interface
//  Business rules for this parking lot are as follows:
//        Basic fee is $4 per hour or fraction thereof
//        This means we always round up; ie, 4 hours 2 minutes is billed as 5 hours.
//        There is no pro-ration
//        Daily max is $27
//        Every 7th day or fraction thereof is free.  (ie, a stay of 13 days and 4 hours will be billed for 12 days

        if (days > 0){
            bill += 27*(days - days/7);
        }
        if (minutes > 0){
            hours++;
        }
        if ((days+1)%7 ==0){
            hours = 0;
        }
        if (hours > 6){
            bill += 27;
        } else {
            bill += hourlyFee * hours;
        }

        return bill;
    }
}
