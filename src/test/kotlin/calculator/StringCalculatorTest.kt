package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest : FunSpec({

    context("수식을 계산한다.") {
        withData(
            "2 + 3 * 4 / 2" to 10L,
            "10 * 2 / 5 + 6" to 10L,
            "32 - 12 / 5 * 10" to 40L
        ) { (input, expected) ->
            val calculator = StringCalculator(Input(input))
            val result = calculator.calculate()
            result shouldBe Operand(expected)
        }
    }

    context("유효하지 않은 수식은 예외를 반환한다.") {
        withData(
            "2 3 4 / 2",
            "10 * / + - 5 + 6",
            "a * b",
            "1 $ 2 & 5"
        ) { input ->
            val calculator = StringCalculator(Input(input))
            assertThrows<IllegalArgumentException> {
                calculator.calculate()
            }
        }
    }
})
