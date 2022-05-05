package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "문자열을 입력 받아 사칙 연산을 수행한다." {
        val stringCalculator = StringCalculator(ExpressionFactory(OneSpaceSeparationStrategy()))

        listOf(
            "2 + 3 * 4 / 2" to 10,
            "2 * 8 / 3 - 5" to 0,
            "3 + 4 - 10 * 8" to -24,
        ).forAll { (expressionText, expected) ->
            stringCalculator.calculate(expressionText) shouldBe expected
        }
    }
})
