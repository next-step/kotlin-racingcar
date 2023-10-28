package calculator.operator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MultiplyOperatorTest : DescribeSpec({

    describe("operate") {
        context("두 값이 주어지면") {
            it("곱한 값을 반환한다.") {
                MultiplyOperator.operate(10.0, 2.0) shouldBe 20.0
            }
        }
    }

    describe("canHandle") {
        listOf(
            Pair("/", false),
            Pair("+", false),
            Pair("-", false),
            Pair("*", true),
        ).forEach { (operator, result) ->
            context("$operator 연산자가 주어지면") {
                it("'$result'를 반환한다") {
                    MultiplyOperator.canHandle(operator) shouldBe result
                }
            }
        }
    }
})
