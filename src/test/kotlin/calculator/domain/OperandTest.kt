package calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperandTest : StringSpec() {
    init {
        "같은 값을 가진 피연산자는 동등성을 갖는다" {
            val one = Operand(1)

            one shouldBe Operand(1)
        }

        "피연산자는 서로 합해질 수 있다" {
            val one = Operand(1)
            val two = Operand(2)

            one.sum(two) shouldBe Operand(3)
        }

        "피연산자는 서로 빼질 수 있다" {
            val one = Operand(1)
            val two = Operand(2)

            one.subtract(two) shouldBe Operand(-1)
        }

        "피연산자는 서로 곱해질 수 있다" {
            val one = Operand(1)
            val two = Operand(2)

            one.multiply(two) shouldBe Operand(2)
        }

        "피연산자는 서로 나눠질 수 있다" {
            val one = Operand(1)
            val two = Operand(2)

            one.divide(two) shouldBe Operand(0)
        }

        "피연산자는 숫자만 가능하다" {
            shouldThrow<NumberFormatException> {
                Operand("a")
            }
        }
    }
}
