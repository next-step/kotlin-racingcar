package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class FormulaTest : DescribeSpec({
    describe("Formula") {

        it("올바른 입력값을 받았을 때 숫자와 연산자를 나누어 가진다.") {
            val inputs = "1 + 2 + 3 + 4"

            val result = Formula(inputs)

            result.numbers shouldBe listOf(1f, 2f, 3f, 4f)
            result.operations shouldBe listOf("+", "+", "+")
        }
    }
})
