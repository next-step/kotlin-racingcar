package calculator.operator

import calculator.operand.Operand
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DivideOperatorTest : DescribeSpec({

    describe("operate") {
        context("두 번째 인자가 0이 주어지면") {
            it("예외가 발생한다") {
                shouldThrowWithMessage<IllegalArgumentException>("0으로 나눌 수 없습니다.") {
                    DivideOperator.operate(Operand.of("10.0"), Operand.of("0.0"))
                }
            }
        }

        context("두 번째 인자가 0이 아닌 값이 주어지면") {
            it("나눈 값을 반환한다") {
                DivideOperator.operate(Operand.of("10.0"), Operand.of("2.0")) shouldBe Operand.of(5.0)
            }
        }
    }
})
