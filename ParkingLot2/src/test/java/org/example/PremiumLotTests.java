package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PremiumLotTests {
    PremiumLot uut;
    Ticket ticket;

    @BeforeEach
    public void setUp(){
        uut = new PremiumLot();
        ticket = mock(Ticket.class);
    }

    @AfterEach
    public void tearDown(){
        uut = null;
        ticket = null;
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,4"})
    public void testHourlyRate(int hours, int result){
        when(ticket.getHours()).thenReturn(hours);
        int actualResult = uut.calculateFee(ticket);
        Assertions.assertEquals(result, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"7,27", "6, 24"})
    public void testDailyMax(int hours, int result){
        when(ticket.getHours()).thenReturn(hours);
        int actualResult = uut.calculateFee(ticket);
        Assertions.assertEquals(result, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0,7,27", "0, 6, 24", "1, 6, 51", "1, 7, 54"})
    public void testMultipleDays(int days, int hours, int result){
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getDays()).thenReturn(days);
        int actualResult = uut.calculateFee(ticket);
        Assertions.assertEquals(result, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0,7,4", "6, 6, 27"})
    public void testMinutesRoundUp(int hours, int minutes, int result){
        when(ticket.getHours()).thenReturn(hours);
        when(ticket.getMinutes()).thenReturn(minutes);
        int actualResult = uut.calculateFee(ticket);
        Assertions.assertEquals(result, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"6,4,162", "5, 6, 159","13,4,324"})
    public void testSeventhDay(int days, int hours, int result){
        when(ticket.getDays()).thenReturn(days);
        when(ticket.getHours()).thenReturn(hours);
        int actualResult = uut.calculateFee(ticket);
        Assertions.assertEquals(result, actualResult);
    }

}
