package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeInstanceOf

class ExpressionKoTest : DescribeSpec({
    describe("수식(사칙연산) 테스트") {
        it("덧셈 테스트") {
            val prev = 3.0
            val next = 2.0
            val operator = Operator.PLUS

            val expression = Expression(prev, operator, next)
            expression.shouldBeInstanceOf<Expression>()

            val result = expression.calculate()
            result.shouldBeInstanceOf<Double>()
            result shouldBe 5.0
        }

        it("뺄셈 테스트") {
            val prev = 3.0
            val next = 2.0
            val operator = Operator.MINUS

            val expression = Expression(prev, operator, next)

            val result = expression.calculate()
            result.shouldBeInstanceOf<Double>()
            result shouldBe 1.0
        }

        it("곱셈 테스트") {
            val prev = 3.0
            val next = 2.0
            val operator = Operator.MULTIPLE

            val expression = Expression(prev, operator, next)

            val result = expression.calculate()
            result.shouldBeInstanceOf<Double>()
            result shouldBe 6.0
        }

        it("나눗셈 테스트") {
            val prev = 3.0
            val next = 2.0
            val operator = Operator.DIVISION

            val expression = Expression(prev, operator, next)

            val result = expression.calculate()
            result.shouldBeInstanceOf<Double>()
            result shouldBe 1.5
        }

        it("익셉션 테스트") {
            val prev = 3.0
            val next = 0.0
            val operator = Operator.DIVISION

            val expression = Expression(prev, operator, next)

            val exception = shouldThrow<IllegalArgumentException> {
                expression.calculate()
            }
            exception.message should startWith("It cannot be divided by zero.")
        }
    }
})
