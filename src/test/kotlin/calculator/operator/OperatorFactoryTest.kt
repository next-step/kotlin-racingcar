package calculator.operator

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec

class OperatorFactoryTest : DescribeSpec({

    describe("findOperator") {
        context("허용하지 않는 연산자가 주어진다면") {
            it("예외가 발생한다.") {
                shouldThrowMessage("지원하지 않는 연산자입니다.") {
                    OperatorFactory.findOperator("%")
                }
            }
        }
    }
})
