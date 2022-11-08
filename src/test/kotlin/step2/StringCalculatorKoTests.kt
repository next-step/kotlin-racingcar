package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import java.lang.IllegalArgumentException

class StringCalculatorKoTests : FreeSpec({
    lateinit var stringCalculator: StringCalculator

    beforeAny {
        stringCalculator = StringCalculator()
    }

    "정상 작동" - {
        listOf(
            "2 + 3 * 4 / 2" to 10,
            "2 * 3 / 4 - 2" to -1,
            "2 / 3 + 4 * 2" to 8
        ).forEach { (expression, expected) ->
            "$expression = $expected - OK" {
                stringCalculator.calculate(expression) shouldBe expected
            }
        }
    }

    "입력값이 널이거나 비어있을 경우" - {
        listOf(
            null,
            " ",
        ).forEach {
            "expression: [$it] - ${ErrorMessage.NULL_OR_BLANK}" {
                val exception = shouldThrow<IllegalArgumentException> {
                    stringCalculator.calculate(it)
                }

                exception.message should startWith(ErrorMessage.NULL_OR_BLANK.message)
            }
        }
    }

    "사칙연산 기호가 아닌 경우" - {
        listOf(
            "2 : 3 * 4 / 2",
            "2 * 3 / 4 ! 2",
            "2 / 3 = 4 - 2"
        ).forEach {
            "expression: [$it] - ${ErrorMessage.INVALID_OPERATOR}" {
                val exception = shouldThrow<IllegalArgumentException> {
                    stringCalculator.calculate(it)
                }

                exception.message should startWith(ErrorMessage.INVALID_OPERATOR.message)
            }
        }
    }

    "피연산자가 숫자가 아닐 경우" - {
        listOf(
            "2 + 3 * 4 / x",
            "2 * x / 4 - 2",
            "x / 3 + 4 - 2"
        ).forEach {
            "expression: [$it] - ${ErrorMessage.INVALID_NUMBER_FORMAT}" {
                val exception = shouldThrow<IllegalArgumentException> {
                    stringCalculator.calculate(it)
                }

                exception.message should startWith(ErrorMessage.INVALID_NUMBER_FORMAT.message)
            }
        }
    }

    "피연산자가 숫자가 모자랄 경우" - {
        listOf(
            "2 + 3 * 4 / ",
            "2 * 3 / 4 - ",
            "2 / 3 + 4 - "
        ).forEach {
            "expression: [$it] - ${ErrorMessage.NOT_ENOUGH_OPERAND}" {
                val exception = shouldThrow<IllegalArgumentException> {
                    stringCalculator.calculate(it)
                }

                exception.message should startWith(ErrorMessage.NOT_ENOUGH_OPERAND.message)
            }
        }
    }
})
