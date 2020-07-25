package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StrCalculatorTest {

    @Test
    fun study_split() {
        val str = "1+2"
        val testList = listOf("1", "2")

        val list = str.split("+")

        assertThat(list).isEqualTo(testList)
    }

    @Test
    fun study_split2() {
        val str = "1+2/3*4"
        val testList = listOf("1", "2", "3", "4")

        val list = str.split("+", "-", "*", "/")

        assertThat(list).isEqualTo(testList)
    }

    @Test
    fun study_split3() {
        val str = "10+2-1/6+2"
        val list = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val testList = listOf("+", "-", "/", "+")

        val filter = list.filter { it != "" }

        assertThat(filter).isEqualTo(testList)
    }

    @Test
    fun string_split() {
        val str = "1+2"
        val testList = listOf(1, 2)

        val strCal = StrCalculator(str)

        assertThat(strCal.numList).isEqualTo(testList)
        assertThat(strCal.symbolList).isEqualTo(listOf("+"))
    }

    @Test
    fun calculate() {
        val str = "10+3-4/3*2"
        val strCal = StrCalculator(str)

        val result = strCal.runCalculator()

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun example() {
        val str = "2 + 3 * 4 / 2"
        val strCal = StrCalculator(str)

        val result = strCal.runCalculator()

        assertThat(result).isEqualTo(10)
    }
}
