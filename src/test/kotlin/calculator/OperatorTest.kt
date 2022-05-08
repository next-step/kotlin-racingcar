package calculator

import io.kotest.assertions.throwables.shouldThrow
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

        context("with - operator") {
            it("뺄셈을 수행한 값을 반환한다.") {
                val operator = Operator()

                val result = operator.evaluate(3f, 4f, "-")

                result shouldBe -1
            }
        }

        context("with * operator") {
            it("곱셈을 수행한 값을 반환한다.") {
                val operator = Operator()

                val result = operator.evaluate(3f, 4f, "*")

                result shouldBe 12
            }
        }

        context("with / operator") {
            it("나눗셈을 수행한 값을 반환한다.") {
                val operator = Operator()

                val result = operator.evaluate(5f, 2f, "/")

                result shouldBe 2.5
            }
        }

        context("with invalid operator") {
            it("IllegalArgumentException 에러를 발생시킨다.") {
                val operator = Operator()

                val exception = shouldThrow<IllegalArgumentException> {
                    operator.evaluate(3f, 2f, "&")
                }

                exception.message shouldBe "유효하지 않은 연산자 입니다."
            }
        }
    }
})
