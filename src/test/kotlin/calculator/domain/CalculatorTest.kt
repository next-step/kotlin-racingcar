package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec() {
    init {
        "연산자와 피연산자가 띄어쓰기로 구분된 식이 있다면 계산할 수 있다" {
            val calculator = Calculator()

            val result = calculator.calculate("3 + 2 * 4 / 5")
            result shouldBe 4
        }

        "빈 공백 문자일 경우 예외가 발생한다" {
            val calculator = Calculator()

            shouldThrow<IllegalArgumentException> {
                calculator.calculate(" ")
            }
        }
    }
}
