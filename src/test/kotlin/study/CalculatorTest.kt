package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun `illegal operator test`() {

        // WHEN
        assertThatThrownBy {
            calculate("3 % 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2:10",
            "2 + 3:5",
            "3 - 2:1",
            "3 * 2:6",
            "6 / 2:3"
        ],
        delimiter = ':'
    )
    fun `simple calculate test`(input: String, calculateResult: Int) {
        assertThat(calculate(input)).isEqualTo(calculateResult)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "' ':' ':5:5:' '",
            "' ':' ':+:' ':+",
            "5:' ':+:5:+",
            "5:+:2:7:' '",
            "5:-:2:3:' '",
            "5:*:2:10:' '",
            "6:/:2:3:' '"
        ],
        delimiter = ':'
    )
    fun `operation test`(
        accumulatorFirst: String,
        accumulatorSecond: String,
        element: String,
        resultFirst: String,
        resultSecond: String
    ) {
        val operationResult = operation(accumulatorFirst.trim() to accumulatorSecond.trim(), element)
        assertThat(operationResult).isEqualTo(resultFirst.trim() to resultSecond.trim())
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2:3:+:5",
            "3:2:-:1",
            "3:2:*:6",
            "6:2:/:3"
        ],
        delimiter = ':'
    )
    fun `execute test`(firstValue: Int, secondValue: Int, operator: String, executeResult: Int) {
        assertThat(execute(firstValue, secondValue, operator)).isEqualTo(executeResult)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null and empty string test`(input: String?) {

        // WHEN
        assertThatThrownBy {
            checkNullAndBlank(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "    "])
    fun `blank string test`(input: String?) {

        // WHEN
        assertThatThrownBy {
            checkNullAndBlank(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `string is operator test`(value: String) {
        assertThat(isOperator(value)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["&", "%", "$", " ", ""])
    fun `string is not operator test`(value: String) {
        assertThat(isOperator(value)).isFalse()
    }
}
