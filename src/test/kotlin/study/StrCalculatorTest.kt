package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StrCalculatorTest {
    @Test
    fun study_split() {
        val str = "1+2"
        val list = str.split("+")
        val testList = listOf("1", "2")
        assertThat(list).isEqualTo(testList)
    }

    @Test
    fun study_split2() {
        val str = "1+2/3*4"
        val list = str.split("+", "-", "*", "/")
        val testList = listOf("1", "2", "3", "4")
        assertThat(list).isEqualTo(testList)
    }

    @Test
    fun study_split3() {
        val str = "10+2-1/6+2"
        val list = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val filter = list.filter { it != "" }
        val testList = listOf("+", "-", "/", "+")
        assertThat(filter).isEqualTo(testList)
    }

    @Test
    fun string_split() {
        val str = "1+2"
        val strCal = StrCalculator(str)
        val testList = listOf(1, 2)
        assertThat(strCal.numList).isEqualTo(testList)
        assertThat(strCal.symbolList).isEqualTo(listOf("+"))
    }

    @Test
    fun plus_minus_multiplication_division() {
        val numList = listOf(2, 1)
        val strCal = StrCalculator("1+2")
        val plus = strCal.plus(numList)
        val minus = strCal.minus(numList)
        val multiplication = strCal.multiplication(numList)
        val division = strCal.division(numList)
        assertThat(plus).isEqualTo(3)
        assertThat(minus).isEqualTo(1)
        assertThat(multiplication).isEqualTo(2)
        assertThat(division).isEqualTo(2)
    }

    @Test
    fun find_FPO() {
        val str = "1+2-3*4/5"
        val strCal = StrCalculator(str)
        val plusSymbol = strCal.isPlus(0)
        val minusSymbol = strCal.isMinus(1)
        val multiplicationSymbol = strCal.isMultiplication(2)
        val divisionSymbol = strCal.isDivision(3)
        assertThat(plusSymbol).isTrue()
        assertThat(minusSymbol).isTrue()
        assertThat(multiplicationSymbol).isTrue()
        assertThat(divisionSymbol).isTrue()
    }
}
