package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperatorTest : DescribeSpec({
    describe("evaluate") {
        context("with + operator") {
            it("덧셈을 수행한 값을 반환한다.") {
                val result = Operator.PLUS.evaluate(3f, 4f)

                result shouldBe 7
            }
        }

        context("with - operator") {
            it("뺄셈을 수행한 값을 반환한다.") {
                val result = Operator.MINUS.evaluate(3f, 4f)

                result shouldBe -1
            }
        }

        context("with * operator") {
            it("곱셈을 수행한 값을 반환한다.") {
                val result = Operator.MULTIPLE.evaluate(3f, 4f)

                result shouldBe 12
            }
        }

        context("with / operator") {
            it("나눗셈을 수행한 값을 반환한다.") {
                val result = Operator.DIVIDE.evaluate(5f, 2f)

                result shouldBe 2.5
            }
        }
    }

    describe("find") {
        it("+가 입력되면 PLUS 객체를 반환한다") {
            val symbol = "+"
            val result = Operator.find(symbol)

            result shouldBe Operator.PLUS
        }

        context("사칙연산 외 다른 연산자일 때") {
            it("IllegalArgumentException가 발생한다") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Operator.find("&")
                }

                exception.message shouldBe "유효하지 않은 연산자 입니다."
            }
        }
    }
})
