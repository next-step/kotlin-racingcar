package calculator.operator

import calculator.operand.Operand
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PlusOperatorTest : DescribeSpec({

    describe("operate") {
        context("두 값이 주어지면") {
            it("더한 값을 반환한다.") {
                PlusOperator.operate(Operand.of("10.0"), Operand.of("2.0")) shouldBe 12.0
            }
        }
    }

    describe("canHandle") {
        listOf(
            Pair("/", false),
            Pair("+", true),
            Pair("-", false),
            Pair("*", false),
        ).forEach { (operator, result) ->
            context("$operator 연산자가 주어지면") {
                it("'$result'를 반환한다") {
                    PlusOperator.canHandle(operator) shouldBe result
                }
            }
        }
    }
})
