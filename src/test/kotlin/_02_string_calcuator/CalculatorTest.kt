package _02_string_calcuator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : DescribeSpec({
    val sut = Calculator()

    describe("calculate") {
        it("입력값이 빈 공백문자인 경우 에러를 발생한다.") {
            val result = shouldThrow<IllegalArgumentException> {
                sut.calculate(" ")
            }

            result.message shouldBe "연산을 위한 값을 입력해주세요."
        }

        it("사칙 연산을 계산한다.") {
            val result = sut.calculate("2 + 3 * 4 / 2")

            result shouldBe 10
        }
    }
})
