package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperatorTest : DescribeSpec({

    describe("Operator") {
        it("더하기를 수행한다.") {
            val operator = Operator.of("+")

            val result = operator.operate(1f, 2f)

            result shouldBe 3f
        }

        it("빼기를 수행한다.") {
            val operator = Operator.of("-")

            val result = operator.operate(2f, 1f)

            result shouldBe 1f
        }

        it("곱셈를 수행한다.") {

            val operator = Operator.of("*")

            val result = operator.operate(2f, 2f)

            result shouldBe 4f
        }

        it("나눗셈를 수행한다.") {
            val operator = Operator.of("/")

            val result = operator.operate(4f, 2f)

            result shouldBe 2
        }

        context("사칙연산 기호가 아닌 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {

                val exception = shouldThrow<IllegalArgumentException> {
                    Operator.of("^")
                }

                exception.message shouldBe "^ 은(는) 옵바른 사칙연산 기호가 아닙니다. (사용 가능 연산: + - * / )"
            }
        }
    }
})
