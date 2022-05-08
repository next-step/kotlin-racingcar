package _02_string_calcuator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CalculatorTest : DescribeSpec({
    val sut = Calculator()

    describe("calculate") {
        it("사칙 연산을 계산한다.") {
            calculations.forAll { (expression, expected) ->
                val result = sut.calculate(expression)

                result shouldBe expected
            }
        }

        it("다중 입력값을 받아 계산한다.") {
            val result = sut.calculate("1", "+", "2")
            result shouldBe 3
        }

        it("입력값이 빈 공백문자인 경우 에러를 발생한다.") {
            blanks.forAll {
                val result = shouldThrow<IllegalArgumentException> {
                    sut.calculate(it)
                }
                result.message shouldBe "연산을 위한 값을 입력해주세요."
            }
        }

        it("숫자가 아닌 문자가 입력된 경우 에러를 발생한다.") {
            invalidNumbers.forAll {
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(it)
                }
            }
        }

        it("사칙 연산이 아닌 문자가 입력된 경우 에러를 발생한다.") {
            invalidOperators.forAll {
                shouldThrow<IllegalArgumentException> {
                    sut.calculate(it)
                }
            }
        }
    }
}) {
    companion object {
        val calculations = listOf(
            "1 + 3 * 5" to 20,
            "2 - 8 / 3 - 3" to -5,
            "1 + 2 + 3 + 4 + 5" to 15
        )

        val blanks = listOf("", " ", "   ")

        val invalidNumbers = listOf("1 & 2", "1 + 5 % 1", "가 * 나")

        val invalidOperators = listOf("1 ! 1", "2 * 4 $ 6")
    }
}
