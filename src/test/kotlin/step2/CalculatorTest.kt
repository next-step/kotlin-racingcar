package step2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "유효한 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = Calculator(SimpleExpressionParser())
        calculator.calculate("9 / 3 * 2 + 3") shouldBe 9
        calculator.calculate("9 * 3 / 3 - 3") shouldBe 6
    }
})
