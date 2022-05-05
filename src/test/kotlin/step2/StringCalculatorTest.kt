package step2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringCalculatorTest {

    @Test
    fun `arithmetic operation test`() {
        val inputStr1 = "2 + 3"
        val expected1 = 5.0
        assertEquals(expected1, StringCalculator(inputStr1).result())

        val inputStr2 = "8 - 1"
        val expected2 = 7.0
        assertEquals(expected2, StringCalculator(inputStr2).result())

        val inputStr3 = "3 * 4"
        val expected3 = 12.0
        assertEquals(expected3, StringCalculator(inputStr3).result())

        val inputStr4 = "8 / 4"
        val expected4 = 2.0
        assertEquals(expected4, StringCalculator(inputStr4).result())
    }

    @Test
    fun `multiple operands test`() {
        val inputStr1 = "2 + 3 * 4 / 2"
        val expected1 = 10.0
        assertEquals(expected1, StringCalculator(inputStr1).result())

        val inputStr2 = "21 * 63 / 3 / 7 - 10"
        val expected2 = 53.0
        assertEquals(expected2, StringCalculator(inputStr2).result())

        val inputStr3 = "223 - 63 * 4 / 2"
        val expected3 = 320.0
        assertEquals(expected3, StringCalculator(inputStr3).result())

        val inputStr4 = "2123 - 10 + 50 / 4"
        val expected4 = 540.75
        assertEquals(expected4, StringCalculator(inputStr4).result())
    }

    @Test
    fun `non-arithmetic operator or non-digit check test`() {
        val inputStr1 = "123 + 삼백"
        assertThrows(IllegalArgumentException::class.java, StringCalculator(inputStr1)::result)

        val inputStr2 = "123 + 3849 ^ 13"
        assertThrows(IllegalArgumentException::class.java, StringCalculator(inputStr2)::result)
    }

    @Test
    fun `black remove test`() {
        val inputStr1 = "2             + 3 * 4 / 2"
        val expected1 = 10.0
        assertEquals(expected1, StringCalculator(inputStr1).result())

        val inputStr2 = "2  1 * 6   3            / 3 / 7 - 10"
        val expected2 = 53.0
        assertEquals(expected2, StringCalculator(inputStr2).result())

        val inputStr3 = "2  2   3 - 6 3          * 4 / 2"
        val expected3 = 320.0
        assertEquals(expected3, StringCalculator(inputStr3).result())

        val inputStr4 = "21         23 - 10 + 50 / 4"
        val expected4 = 540.75
        assertEquals(expected4, StringCalculator(inputStr4).result())
    }
}