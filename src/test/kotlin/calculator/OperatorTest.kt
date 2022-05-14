package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperatorTest : DescribeSpec({

    describe("Operator") {
        it("symbol 에 해당하는 연산자를 찾아준다.") {
            val operator = Operator.of("+")

            operator.symbol shouldBe "+"
            operator.operate(1f, 2f) shouldBe 3
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
