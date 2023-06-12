package calcurate.koTest

import calcurate.ErrorCode
import calcurate.expression.Expression
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalcTest : BehaviorSpec({

    data class CalcBehavior(
        val expressionStr: String,
        val whenDesc: String,
        val thenDesc: String,
        val expect: Double,
    )

    suspend fun BehaviorSpecGivenContainerScope.calcSuccessBehaviorWithParams(
        list: List<CalcBehavior>,
    ) {
        list.forAll { (expressionStr, whenDesc, thenDesc, expect) ->
            val expression = Expression(expressionStr)

            this.`when`(whenDesc) {
                val result = expression.calculation()
                this.then(thenDesc) {
                    result shouldBe expect
                }
            }
        }
    }

    /**
     * Success Case
     */
    given("덧셈 성공") {
        calcSuccessBehaviorWithParams(
            listOf(
                CalcBehavior("3 + 2 + 5", "3, 2, 5 를 더하면", "10이 된다", 10.0),
                CalcBehavior("2 + 7 + 2", "2, 7, 2 를 더하면", "11이 된다", 11.0),
            ),
        )
    }

    given("뺄셈 성공") {
        calcSuccessBehaviorWithParams(
            listOf(
                CalcBehavior("20 - 5 - 2", "20에서 5, 2 를 빼면", "13이 된다", 13.0),
                CalcBehavior("13 - 2 - 5", "13에서 2, 5 를 빼면", "6이 된다", 6.0),
            ),
        )
    }

    given("곱셈 성공") {
        calcSuccessBehaviorWithParams(
            listOf(
                CalcBehavior("50 * 2 * 3", "50, 2, 3 을 곱하면", "300이 된다", 300.0),
                CalcBehavior("3 * 2 * 5", "3, 2, 5 를 곱하면", "30이 된다", 30.0),
            ),
        )
    }

    given("나눗셈 성공") {
        calcSuccessBehaviorWithParams(
            listOf(
                CalcBehavior("1000 / 100 / 5", "1000 을 100, 5 으로 나누면", "2가 된다", 2.0),
                CalcBehavior("20 / 2 / 10", "20 을 2, 10 으로 나누면", "1가 된다", 1.0),
            ),
        )
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
