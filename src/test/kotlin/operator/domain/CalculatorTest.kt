package operator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @CsvSource( "3+3/2, 3.0", "3 - 2, 1.0" )
    fun `옮바른 입력값에 계산이 제대로 동작하는지 테스트`(value: String, expect: Double) {
        val calculator = Calculator()
        val result = calculator.calculate(value)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["3+", "3--2", "3/0"])
    fun `잘못된 값이 들어갔을 때 처리하는지 테스트`(value: String) {
        val calculator = Calculator()

        assertThrows<IllegalArgumentException> {
            calculator.calculate(value)
        }
    }
}
