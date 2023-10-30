package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LongTermParkingLotTests {

    LongTermParkingLot uut;

    Ticket mockTicket;

    int actualResult;

    @BeforeEach
    public void setUp() {
        uut = new LongTermParkingLot();
        mockTicket = mock(Ticket.class);
    }

    @AfterEach
    public void tearDown() {
        uut = null;
        mockTicket = null;
    }

    @Test
    public void testNotNull(){
        Assertions.assertNotNull(uut);
    }

    @ParameterizedTest
    @CsvSource({"0,1,0,2"})
    public void test1HourStay(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({"1,0,0,15"})
    public void test1DayStay(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0,0,1,0"})
    public void test1MinuteStay(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({"1,1,1,19"})
    public void test1DayHourMinuteStay(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0,0,1,0","0,0,30,0"})
    public void testFirst30MinutesStay(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({"0,8,0,15","0,8,5,15"})
    public void testMaxDailyCharge(int days, int hours, int minutes, int expectedResult){
        when(mockTicket.getDays()).thenReturn(days);
        when(mockTicket.getHours()).thenReturn(hours);
        when(mockTicket.getMinutes()).thenReturn(minutes);

        actualResult = uut.calculateFee(mockTicket);

        Assertions.assertEquals(expectedResult,actualResult);
    }

}
