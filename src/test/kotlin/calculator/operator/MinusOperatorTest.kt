package calculator.operator

import calculator.operand.Operand
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MinusOperatorTest : DescribeSpec({

    describe("operate") {
        context("두 값이 주어지면") {
            it("뺀 값을 반환한다.") {
                MinusOperator.operate(Operand.of("10.0"), Operand.of("2.0")) shouldBe Operand.of(8.0)
            }
        }
    }
})
