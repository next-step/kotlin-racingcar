package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CalculatorTest : StringSpec({
    "문자열 계산기는 연산자 순서대로 계산을 진행해요." {
        val expression = Expression("2 + 3 * 4 / 2")
        val calculator = Calculator(Parser())

        calculator.calculate(expression) shouldBe 10
        calculator.calculate(expression) shouldNotBe 8
    }
})
