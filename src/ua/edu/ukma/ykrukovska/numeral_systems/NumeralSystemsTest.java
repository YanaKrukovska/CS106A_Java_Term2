package ua.edu.ukma.ykrukovska.numeral_systems;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumeralSystemsTest {

    @Test
    public void validate10SystemSuccess() {
        assertTrue( NumeralSystems.validateNumeralSystem(10, "1488"));
    }

    @Test
    public void validate10SystemFail() {
        Assert.assertFalse( NumeralSystems.validateNumeralSystem(10, "148A"));
    }

    @Test
    public void validate16SystemSuccess() {
        assertTrue( NumeralSystems.validateNumeralSystem(16, "0123456789ABCDEF"));
    }

    @Test
    public void validate2SystemSuccess() {
        assertTrue( NumeralSystems.validateNumeralSystem(2, "010101011"));
    }

    @Test
    public void validate2SystemFail() {
        assertFalse( NumeralSystems.validateNumeralSystem(2, "010121011"));
    }

    @Test
    public void convertToTen() {
        assertEquals(34, NumeralSystems.convertToTen("54", 6));
    }

    @Test
    public void convert16To10() {
        assertEquals(15, NumeralSystems.convertToTen("F", 16));
    }

    @Test
    public void convertToSystem() {
        assertEquals( "F", NumeralSystems.convertToSystem("1111", 2, 16) );
    }

    @Test
    public void convert15To2() {
        assertEquals( "11110111011010100010010", NumeralSystems.convertToSystem("AA2257", 15, 2) );
    }

    @Test
    public void convert10To12() {
        assertEquals( "B10B1", NumeralSystems.convertToSystem("229957", 10, 12) );
    }
}