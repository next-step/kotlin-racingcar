package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MathTest : DescribeSpec({
    describe("덧셈") {
        it("5 + 3 = 8") {
            val result = Math.plus(5, 3)

            result shouldBe 8
        }
    }

    describe("뺄셈") {
        it("5 - 3 = 2") {
            val result = Math.minus(5, 3)

            result shouldBe 2
        }
    }

    describe("곱셈") {
        it("5 * 3 = 15") {
            val result = Math.multiple(5, 3)

            result shouldBe 15
        }
    }

    describe("나눗셈") {
        it("6 / 3 = 2") {
            val result = Math.divide(6, 3)

            result shouldBe 2
        }

        it("0으로 나눌 경우 IllegalArgumentException 을 던진다.") {
            val zero = 0L

            val exception = shouldThrow<IllegalArgumentException> {
                Math.divide(6, zero)
            }

            exception.message shouldBe "유효하지 않은 입력 값입니다."
        }
    }
})
