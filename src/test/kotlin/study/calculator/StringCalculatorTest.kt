package study.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.endWith
import io.kotest.matchers.string.startWith

/**
 * @author 이상준
 */
class StringCalculatorTest : StringSpec({
    val stringCalculator = StringCalculator()
    var expression: String

    "expressionToArrayDequeue" {
        expression = "1 + 2"
        val result = stringCalculator.expressionToArrayDeque(expression)

        result.removeFirst() shouldBe "1"
        result.removeFirst() shouldBe "+"
        result.removeFirst() shouldBe "2"
    }

    "validate" {
        expression = "1 + 2"
        var result = stringCalculator.expressionToArrayDeque(expression)
        stringCalculator.validate(result)

        expression = "1 + 2 - 10 * 20 / 30"
        result = stringCalculator.expressionToArrayDeque(expression)
        stringCalculator.validate(result)

        expression = "1 + 2 +"
        result = stringCalculator.expressionToArrayDeque(expression)
        var exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.validate(result)
            }
        exception.message should startWith("first or last is Not number")

        expression = "1 - 2 * 10 / 10 "
        result = stringCalculator.expressionToArrayDeque(expression)
        exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.validate(result)
            }
        exception.message should startWith("first or last is Not number")

        expression = "1 + 2 + 1 & 3"
        result = stringCalculator.expressionToArrayDeque(expression)
        exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.validate(result)
            }
        exception.message should endWith("is Not operators..")

        expression = ""
        result = stringCalculator.expressionToArrayDeque(expression)
        exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.validate(result)
            }
        exception.message should startWith("first or last is Not number")
    }

    "expressionCalculate" {
        expression = "1 + 2"
        var result = stringCalculator.expressionCalculate(expression)
        result shouldBe 3

        expression = "3 - 2"
        result = stringCalculator.expressionCalculate(expression)
        result shouldBe 1

        expression = "3 * 2"
        result = stringCalculator.expressionCalculate(expression)
        result shouldBe 6

        expression = "4 / 2"
        result = stringCalculator.expressionCalculate(expression)
        result shouldBe 2

        expression = "1 + 2 + 10 + 20"
        result = stringCalculator.expressionCalculate(expression)
        result shouldBe 33

        expression = "1 + 2 + 1 & 3"
        var exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.expressionCalculate(expression)
            }
        exception.message should endWith("is Not operators..")

        expression = "1 + 2 + 1 - 3 *"
        exception =
            shouldThrow<IllegalArgumentException> {
                stringCalculator.expressionCalculate(expression)
            }
        exception.message should startWith("first or last is Not number")
    }
})
