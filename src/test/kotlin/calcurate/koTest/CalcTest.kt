package calcurate.koTest

import calcurate.ErrorCode
import calcurate.expression.Expression
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalcTest : BehaviorSpec({
    /**
     * Success Case
     */
    given("덧셈 성공") {
        val expression = Expression("3 + 2 + 5")

        `when`("3, 2, 5 를 더하면") {
            val result = expression.calculation()
            then("10이 된다") {
                result shouldBe 10.0
            }
        }
    }

    given("뺄셈 성공") {
        val expression = Expression("20 - 5 - 2")

        `when`("20 에서 5, 2 를 빼면") {
            val result = expression.calculation()
            then("13이 된다") {
                result shouldBe 13.0
            }
        }
    }

    given("곱셈 성공") {
        val expression = Expression("50 * 2 * 3")

        `when`("50, 2, 3 을 곱하면") {
            val result = expression.calculation()
            then("300이 된다") {
                result shouldBe 300.0
            }
        }
    }

    given("나눗셈 성공") {
        val expression = Expression("1000 / 100 / 5")

        `when`("1000 을 100, 5 으로 나누면") {
            val result = expression.calculation()
            then("2가 된다") {
                result shouldBe 2.0
            }
        }
    }

    /**
     * Fail Case
     */
    given("나누는 값이 0") {
        val invalidValue = 0.0
        val expression = Expression("1000 / 100 / $invalidValue")

        `when`("어떤 값을 0으로 나누면") {
            shouldThrowMessage(ErrorCode.INVALID_DIVIDE_VALUE.msg) {
                expression.calculation()
            }
        }
    }

    given("expression 이 null 혹은 빈 공백 문자") {
        val nullExpressionParam = null
        val emptyExpressionParam = " "

        `when`("expression이 null 값이면") {
            shouldThrowMessage(ErrorCode.INVALID_EXPRESSION.msg) {
                Expression(nullExpressionParam)
            }
        }
        `when`("expression이 빈 공백 문자 값이면") {
            shouldThrowMessage(ErrorCode.INVALID_EXPRESSION.msg) {
                Expression(emptyExpressionParam)
            }
        }
    }

    given("사칙 연산 기호가 아닌 경우") {
        val invalidCalcSymbol = "?"

        `when`("? 기호인 경우") {
            shouldThrowMessage(ErrorCode.INVALID_CALC_SYMBOL.msg) {
                Expression("10 + 20 $invalidCalcSymbol 1")
            }
        }
    }
})
