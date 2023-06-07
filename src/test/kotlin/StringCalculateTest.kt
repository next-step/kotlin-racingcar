
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculateTest {
    @ParameterizedTest
    @ValueSource(strings = [ "2 + 3 * 4 / 2" ])
    fun testSquares(input: String) {

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(10, result)
    }

    @Test
    fun `덧셈`() {
        val input = "5 + 6 + 9 + 10"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(30, result)
    }

    @Test
    fun `여러 자릿수 덧셈`() {
        val input = "15 + 100 + 1500 + 1"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(1616, result)
    }

    @Test
    fun `뺄셈`() {
        val input = "10 - 5 - 3 - 1"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(1, result)
    }

    @Test
    fun `여러 자릿수 뺄셈`() {
        val input = "100 - 10 - 20 - 5"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(65, result)
    }

    @Test
    fun `곱셈`() {
        val input = "5 * 5 * 5"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(125, result)
    }

    @Test
    fun `여러 자릿수 곱셈`() {
        val input = "100 * 5 * 2"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(1000, result)
    }

    @Test
    fun `나눗셈`() {
        val input = "50 / 5 / 2"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(5, result)
    }

    @Test
    fun `여러 자릿수 나눗셈`() {
        val input = "100 / 5 / 3"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(6, result)
    }

    @Test
    fun `복합 계산`() {
        val input = "50 + 9 * 5 * 3 - 111 / 2"

        val calculator = StringCalculate()
        val result = calculator.calculate(input)

        Assertions.assertEquals(387, result)
    }
}
