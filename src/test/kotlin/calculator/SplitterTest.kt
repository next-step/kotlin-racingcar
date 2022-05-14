package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SplitterTest : DescribeSpec({
    describe("Splitter") {
        it("올바른 입력값이 아닐때, 에러를 던진다.") {
            val inputs = "1 + 2 + 3 4"

            val exception = shouldThrow<IllegalArgumentException> {
                Splitter(inputs)
            }

            exception.message shouldBe "올바른 입력 값이 아닙니다."
        }

        it("올바른 입력값을 받았을 때 숫자와 연산자를 나누어 가진다.") {
            val inputs = "1 + 2 + 3 + 4"

            val result = Splitter(inputs)

            result.numbers shouldBe listOf(1f, 2f, 3f, 4f)
            result.operations shouldBe listOf("+", "+", "+")
        }
    }
})
