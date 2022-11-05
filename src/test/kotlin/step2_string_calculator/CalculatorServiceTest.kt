package step2_string_calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class CalculatorServiceTest : StringSpec({
    val calculatorService = CalculatorService()

    "입력 값이 Null 인 경우 IllegalArgumentException 을 반환한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            calculatorService.verifyExpression(null)
        }
        exception.message should startWith("입력 값이 올바르지 않습니다.")
    }

    "입력 값이 공백인 경우 IllegalArgumentException 을 반환한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            calculatorService.verifyExpression(" ")
        }
        exception.message should startWith("입력 값이 올바르지 않습니다.")
    }

    "사칙 연산 기호가 아닌 경우 IllegalArgumentException 을 반환한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            val input = "3 & 8"
            val exp = input.trim().split(" ")
            calculatorService.calculator(exp)
        }
        exception.message should startWith("잘못된 연산자 입니다.")
    }

    "피연산자는 소수일 수 없다." {
        val exception = shouldThrow<IllegalArgumentException> {
            val input = "3.45 + 8"
            val exp = input.trim().split(" ")
            calculatorService.calculator(exp)
        }
        exception.message should startWith("피연산자는 자연수여야 합니다.")
    }

    "피연산자는 문자일 수 없다." {
        val exception = shouldThrow<IllegalArgumentException> {
            val input = "wow - kotlin"
            val exp = input.trim().split(" ")
            calculatorService.calculator(exp)
        }
        exception.message should startWith("피연산자는 자연수여야 합니다.")
    }

    "식을 입력하면 올바른 결과값이 반환된다." {
        expressions.forAll { (input, output) ->
            val exp = input.trim().split(" ")
            val result = calculatorService.calculator(exp)
            result shouldBe output
        }
    }

    "잘못된 형식의 입력 값은 IllegalArgumentException 을 반환한다." {
        badExpressions.forAll {
            shouldThrow<IllegalArgumentException> {
                val exp = it.trim().split(" ")
                calculatorService.calculator(exp)
            }
        }
    }

    "0 으로 나누는 경우는 IllegalArgumentException 을 반환한다." {
        val exception = shouldThrow<IllegalArgumentException> {
            val exp = "3 / 0".trim().split(" ")
            calculatorService.calculator(exp)
        }
        exception.message shouldBe startWith("0 으로 나눌 수 없습니다.")
    }
}) {
    companion object {
        private val expressions = listOf(
            " 3 + 5 / 2 * 7" to 28,
            "4 * 7 / 2 + 3" to 17,
            "2 + 3 * 4 / 2" to 10
        )
        private val badExpressions = listOf(
            "28 - 20 + -3 * 2",
            "5 ^ 7",
            "woowahan"
        )
    }
}
