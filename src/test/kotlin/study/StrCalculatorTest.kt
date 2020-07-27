package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StrCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1+2"])
    fun study_split(str: String) {
        val testList = listOf("1", "2")

        val list = str.split("+")

        assertThat(list).isEqualTo(testList)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2/3*4"])
    fun study_split2(str: String) {
        val testList = listOf("1", "2", "3", "4")

        val list = str.split("+", "-", "*", "/")

        assertThat(list).isEqualTo(testList)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10+2-1/6+2"])
    fun study_split3(str: String) {
        val list = str.split("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val testList = listOf("+", "-", "/", "+")

        val filter = list.filter { it != "" }

        assertThat(filter).isEqualTo(testList)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2"])
    fun string_split(str: String) {
        val testList = listOf(1, 2)

        val strCal = StrCalculator(str)

        assertThat(strCal.numList).isEqualTo(testList)
        assertThat(strCal.symbolList).isEqualTo(listOf("+"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["10+3-4/3*2"])
    fun calculate(str: String) {
        val strCal = StrCalculator(str)

        val result = strCal.runCalculator()

        assertThat(result).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun example(str: String) {
        val strCal = StrCalculator(str)

        val result = strCal.runCalculator()

        assertThat(result).isEqualTo(10)
    }
}
