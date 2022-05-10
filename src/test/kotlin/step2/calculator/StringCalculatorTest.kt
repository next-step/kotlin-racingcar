package step2.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2=10",
            "2=2",
            "2 + 5=7"
        ],
        delimiter = '='
    )
    fun `계산 성공`(input: String, expected: Int) {
        val result = StringCalculator.execute(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + 3 = 5",
            "2 + 7 = 9",
            "2 + 0 + 9 + 3 = 14"
        ]
    )
    fun `덧셈 테스트`(input: String) {
        input.split(" = ").also {
            val result = Calculator.calculate(it.first())
            assertThat(result).isEqualTo(it.last().toInt())
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "5 - 3 = 2",
            "7 - 2 = 5",
            "2 - 1 = 1"
        ]
    )
    fun `뺄셈 테스트`(input: String) {
        input.split(" = ").also {
            val result = Calculator.calculate(it.first())
            assertThat(result).isEqualTo(it.last().toInt())
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "6 / 3 = 2",
            "8 / 2 = 4",
            "9 / 1 = 9"
        ]
    )
    fun `나눗셈 테스트`(input: String) {
        input.split(" = ").also {
            val result = Calculator.calculate(it.first())
            assertThat(result).isEqualTo(it.last().toInt())
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "6 * 8 = 48",
            "8 * 2 = 16",
            "9 * 9 = 81"
        ]
    )
    fun `곱셈 테스트`(input: String) {
        input.split(" = ").also {
            val result = Calculator.calculate(it.first())
            assertThat(result).isEqualTo(it.last().toInt())
        }
    }
}
