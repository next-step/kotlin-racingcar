package study.calculation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculationTest {
    @ParameterizedTest
    @CsvSource("1,1,2", "2,2,4", "3,2,5", "5,7,12", "10,5,15")
    fun 덧셈(a: Int, b: Int, expected: Int) {
        val calculation: (Int, Int) -> Int = Operator.select("+").calculation
        assertThat(calculation(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,1,0", "2,3,-1", "3,2,1", "10,7,3", "100,50,50")
    fun 뺄셈(a: Int, b: Int, expected: Int) {
        val calculation: (Int, Int) -> Int = Operator.select("-").calculation
        assertThat(calculation(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,1,1", "0,4,0", "3,2,6", "10,10,100", "100,100,10000")
    fun 곱셈(a: Int, b: Int, expected: Int) {
        val calculation: (Int, Int) -> Int = Operator.select("*").calculation
        assertThat(calculation(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,1,1", "4,2,2", "10,5,2", "10,10,1", "900,100,9")
    fun 나눗셈(a: Int, b: Int, expected: Int) {
        val calculation: (Int, Int) -> Int = Operator.select("/").calculation
        assertThat(calculation(a, b)).isEqualTo(expected)
        val calculation: Calculation = CalculationFactory.create("/")
    }
}
