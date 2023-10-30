package org.example;

public class LongTermParkingLot implements ParkingLot {
    @Override
    public int calculateFee(Ticket ticket) {
// ToDo:  Use TDD to Implement this function
//  You will need to mock the Ticket interface
//  Business rules for this parking lot are as follows:
//        Basic fee is $2 per hour or fraction thereof
//        This means we always round up; ie, 4 hours 2 minutes is billed as 5 hours.
//        There is no pro-ration
//        Daily max is $15
//        On the first day, the first half hour is free

        int hours = ticket.getHours();
        int days = ticket.getDays();
        int minutes = ticket.getMinutes();

        int hourFee;
        int dayFee;
        int parkingFee;

        if (days == 0 && hours == 0 && minutes <= 30) {
            parkingFee = 0;
        } else {
            dayFee = days * 15;
            if (minutes > 0) {
                hours += 1;
            }
            if (hours > 7)
                hourFee = 15;
            else {
                hourFee = hours * 2;
            }
            parkingFee = dayFee + hourFee;
        }

        return parkingFee;

    }
}
