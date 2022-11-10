package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeInstanceOf

class OperatorKoTest : DescribeSpec({
    describe("기본 사칙 연산 테스트") {
        it("덧셈 테스트") {
            val input = "+"
            val operator = Operator.find(input)
            operator.shouldBeInstanceOf<Operator>()
            operator shouldBe Operator.PLUS
        }

        it("뺄셈 테스트") {
            val input = "-"
            val operator = Operator.find(input)

            operator shouldBe Operator.MINUS
        }

        it("곱셈 테스트") {
            val input = "*"
            val operator = Operator.find(input)

            operator shouldBe Operator.MULTIPLE
        }

        it("나눗셈 테스트") {
            val input = "/"
            val operator = Operator.find(input)

            operator shouldBe Operator.DIVISION
        }

        it("익셉션 테스트") {
            val input = ""

            val exception = shouldThrow<IllegalArgumentException> {
                Operator.find(input)
            }
            exception.message should startWith("Operator not allowed.")
        }
    }
})
