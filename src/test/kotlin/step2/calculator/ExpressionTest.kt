package step2.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : StringSpec({
    "식은 띄어쓰기 단위로 inputData를 분리한다" {
        val inputData = "1 + 2 * 3"
        val expression = TokenizedExpression(inputData)
        expression.generate() shouldBe listOf("1", "+", "2", "*", "3")
    }
})
