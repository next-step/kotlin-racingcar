package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = ["1 + 2=3", " -1 + 3 =2", "${Int.MIN_VALUE}+1=-2147483647", "0+1+2=3", "01+1=2", "1.0+2=3", "1.0+2.1=3.1", "1.3+1.3=2.6"],
        delimiter = '='
    )
    fun `더하기`(input: String, expected: String) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["4-2=2", "1.2-0.1=1.1", "2-4=-2", "0-2=-2", "-2-1=-3", "${Int.MAX_VALUE}-1=2147483646", "1.1-0.1=1"],
        delimiter = '='
    )
    fun 빼기(input: String, expected: String) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1/2=0", "4/2= 2", "4.0/3.0=1.3"], delimiter = '='
    )
    fun 나누기(input: String, expected: String) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1*2=2", "0*2=0", "4.0*3.0=12"], delimiter = '='
    )
    fun 곱하기(input: String, expected: String) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2+3*4/2=10", "3*4-2*2=20", "0/3*4+3=3"], delimiter = '='
    )
    fun 슈퍼_사칙_연산(input: String, expected: String) {
        val result = Calculator().calculate(input)
        assertThat(result).isEqualTo(expected)
    }
}
