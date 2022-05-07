package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        describe("plus") {
            it("계산식에 + 연산자가 있다면 더하기를 수행한다.") {
                val calculator = Calculator()

                calculator.calculate("3 + 2")

                calculator.total shouldBe 5L
            }
        }
    }
})
