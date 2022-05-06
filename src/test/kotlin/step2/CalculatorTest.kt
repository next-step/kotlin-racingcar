package step2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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
}
