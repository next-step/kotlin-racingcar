package camp.nextstep.edu.step2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class StringCalculatorKtTest {

    @Test
    @DisplayName("5 + 1 = 6")
    fun plus() {
        val calculator = StringCalculator()
        assertEquals(6, calculator.calculate("5 + 1"))
    }

    @Test
    @DisplayName("5 - 10 = -5")
    fun minus() {
        val calculator = StringCalculator()
        assertEquals(-5, calculator.calculate("5 - 10"))
    }

    @Test
    @DisplayName("10 / 5 = 2")
    fun divide() {
        val calculator = StringCalculator()
        assertEquals(2, calculator.calculate("10 / 5"))
    }

    @Test
    @DisplayName("10 * 5 = 50")
    fun multiply() {
        val calculator = StringCalculator()
        assertEquals(50, calculator.calculate("10 * 5"))
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 = 10")
    fun composition_tc_1() {
        val calculator = StringCalculator()
        assertEquals(10, calculator.calculate("2 + 3 * 4 / 2"))
    }

    @Test
    @DisplayName("10 * 4 / 2 = 20")
    fun composition_tc_2() {
        val calculator = StringCalculator()
        assertEquals(20, calculator.calculate("10 * 4 / 2"))
    }

    @Test
    @DisplayName("100 + 10 + 1 - 1 - 10 - 100 = 0")
    fun composition_tc_3() {
        val calculator = StringCalculator()
        assertEquals(0, calculator.calculate("100 + 10 + 1 - 1 - 10 - 100"))
    }
}
