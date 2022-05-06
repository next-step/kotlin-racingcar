package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource("1 + 2, 3", "10 + 20 + 30 + 40, 100")
    fun `덧셈 테스트`(expression: String, expect: Double) {
        val actual = InOrderCalculator().calculate(expression)
        actual shouldBe expect
    }

    @ParameterizedTest
    @CsvSource("1 - 2, -1", "100 - 2 - 10, 88")
    fun `뺄셈 테스트`(expression: String, expect: Double) {
        val actual = InOrderCalculator().calculate(expression)
        actual shouldBe expect
    }

    @ParameterizedTest
    @CsvSource("1 * 2, 2", "0 * 1, 0", "5 * 10 * 3, 150")
    fun `곱셈 테스트`(expression: String, expect: Double) {
        val actual = InOrderCalculator().calculate(expression)
        actual shouldBe expect
    }

    @ParameterizedTest
    @CsvSource("1 / 2, 0.5", "60 / 2 / 3, 10")
    fun `나눗셈 테스트`(expression: String, expect: Double) {
        val actual = InOrderCalculator().calculate(expression)
        actual shouldBe expect
    }

    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2, 10", "5 / 2 - 1 * 3 + 0.5, 5")
    fun `종합 테스트`(expression: String, expect: Double) {
        val actual = InOrderCalculator().calculate(expression)
        actual shouldBe expect
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `입력값이 공백인 경우 예외`(expression: String) {
        val exception = shouldThrow<IllegalArgumentException> {
            InOrderCalculator().calculate(expression)
        }
        println(exception.message)
    }

    @ParameterizedTest
    @NullSource
    fun `입력값이 널인 경우 예외`(expression: String?) {
        val exception = shouldThrow<IllegalArgumentException> {
            InOrderCalculator().calculate(expression)
        }
        println(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 = 2", "100 % 5", "1 a 2", "1 1 1"])
    fun `연산자가 올바르지 않은 경우 예외`(expression: String) {
        val exception = shouldThrow<IllegalArgumentException> {
            InOrderCalculator().calculate(expression)
        }
        println(exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 - - 2 3", "100 - 5 +"])
    fun `식이 올바르지 않은 경우`(expression: String) {
        val exception = shouldThrow<IllegalArgumentException> {
            InOrderCalculator().calculate(expression)
        }
        println(exception.message)
    }
}
