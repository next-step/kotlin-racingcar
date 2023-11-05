package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorKtTest {

    @ParameterizedTest
    @MethodSource("calculators")
    fun `숫자와 연산기호로 구성된 표현식의 연산을 수행한다`(expression: String, expect: Int) {
        val calculator = Calculator()
        calculator.calculate(expression) shouldBe expect
    }

    @Test
    fun `숫자를 0으로 나누면 예외가 발생한다`() {
        val calculator = Calculator()
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("10 / 0")
        }
    }

    companion object {
        @JvmStatic
        fun calculators() = listOf(
            Arguments { arrayOf("10 + 4 - 5 * 7 / 21", 3) },
            Arguments { arrayOf("7 - 10 * 5", -15) },
            Arguments { arrayOf("10", 10) }
        )
    }
}
