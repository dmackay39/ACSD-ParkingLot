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

}
