package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperatorTest : DescribeSpec({
    describe("evaluate") {
        context("with + operator") {
            it("덧셈을 수행한 값을 반환한다.") {
                val operator = Operator()

                val result = operator.evaluate(3f, 4f, "+")

                result shouldBe 7
            }
        }
    }
})
