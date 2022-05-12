package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorsTest {
    @ParameterizedTest
    @CsvSource("1,2,3", "2,3,5", "4.2,5.3,9.5")
    fun plus(a: Double, b: Double, expected: Double) {
        assertThat(Operators.plus(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,3,-1", "5,3,2", "9.5,4.2,5.3")
    fun subtract(a: Double, b: Double, expected: Double) {
        assertThat(Operators.subtract(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,2,2", "2,3,6", "4.2,5.3,22.26")
    fun multiply(a: Double, b: Double, expected: Double) {
        assertThat(Operators.multiply(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,2,1", "6,3,2", "23,2.5,9.2")
    fun division(a: Double, b: Double, expected: Double) {
        assertThat(Operators.division(a, b)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("2,0")
    fun division0Error(a: Double, b: Double) {
        assertThatThrownBy{
            Operators.division(a, b)
        }.hasMessageContaining(Operators.division0ErrorMessage)
    }
}
