import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun testSquares(input: String) {

        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(10, result)
    }

    @ParameterizedTest
    @CsvSource(
        "5 + 6 + 9 + 10, 30",
        "15 + 100 + 1500 + 1, 1616"
    )
    fun `덧셈`(input: String, expected: Int) {
        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "10 - 5 - 3 - 1, 1",
        "100 - 10 - 20 - 5, 65"
    )
    fun `뺄셈`(input: String, expected: Int) {
        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "5 * 5 * 5, 125",
        "100 * 5 * 2, 1000"
    )
    fun `곱셈`(input: String, expected: Int) {
        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "50 / 5 / 2, 5",
        "100 / 5 / 3, 6"
    )
    fun `나눗셈`(input: String, expected: Int) {
        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "50 + 9 * 5 * 3 - 111 / 2, 387",
        "33 + 1 * 2 * 2 - 1111 / 2, -487"
    )
    fun `복합 계산`(input: String, expected: Int) {
        val calculator = StringCalculator()
        val result = calculator.calculate(input)

        Assertions.assertEquals(expected, result)
    }
}
