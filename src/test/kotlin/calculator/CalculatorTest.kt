package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.OutputStream

class CalculatorTest {
    private fun setUpCalculator(expression: String, outputStream: OutputStream): Calculator =
        Calculator(expression.byteInputStream(), outputStream)

    @ParameterizedTest
    @CsvSource(
        value = [
            "10 + 2, 12",
            "10 - 2, 8",
            "10 / 2, 5",
            "10 * 2, 20",
        ]
    )
    fun `하나의 연산자가 포함된 식`(expression: String, expected: String) {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator(expression, outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "10 + 2 - 4, 8",
            "10 - 2 * 4, 32",
            "10 * 2 / 4, 5",
            "10 / 2 + 4, 9",
        ]
    )
    fun `두 개의 연산자가 포함된 식`(expression: String, expected: String) {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator(expression, outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "10 + 2 - 4 * 5, 40",
            "10 - 2 * 4 / 5, 6",
            "10 * 2 / 4 + 5, 10",
            "10 / 2 + 4 - 5, 4",
        ]
    )
    fun `세 개의 연산자가 포함된 식`(expression: String, expected: String) {
        val outputStream = ByteArrayOutputStream()
        setUpCalculator(expression, outputStream).also { it.run() }

        assertEquals(String(outputStream.toByteArray()), expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 ? 2", "1 _ 2", "1 = 2"])
    fun `부적절한 연산자가 포함된 식`(expression: String) {
        val outputStream = ByteArrayOutputStream()

        assertThatThrownBy {
            setUpCalculator(expression, outputStream).also { it.run() }
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("Wrong operator!")
    }

    @ParameterizedTest
    @EmptySource
    fun `비어있는 식`(expression: String) {
        val outputStream = ByteArrayOutputStream()

        assertThatThrownBy {
            setUpCalculator(expression, outputStream).also { it.run() }
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessage("Empty expression!")
    }
}
