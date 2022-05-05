package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "문자열을 입력 받아 사칙 연산을 수행한다." {
        val stringCalculator = StringCalculator(ExpressionFactory(OneSpaceSeparationStrategy()))
        val parameters = listOf(
            StringCalculatorFixture("2 + 3 * 4 / 2", 10),
            StringCalculatorFixture("2 * 8 / 3 - 5", 0),
            StringCalculatorFixture("3 + 4 - 10 * 8", -24),
        )

        parameters.forEach {
            stringCalculator.calculate(it.expression) shouldBe it.expected
        }
    }
})
