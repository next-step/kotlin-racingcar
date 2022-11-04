package calculator.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec() {
    init {
        "Operator는 + - * / 로 생성할 수 있다" {
            shouldNotThrowAny {
                Operator("+")
                Operator("-")
                Operator("*")
                Operator("/")
            }
        }

        "Operator는 + - * / 가 아니면 예외가 발생한다" {
            shouldThrow<IllegalArgumentException> {
                Operator("1")
            }
        }

        "+ Operator는 값을 더한다" {
            val result = Operator("+").operate(Operand(1), Operand(2))

            result shouldBe Operand(3)
        }

        "- Operator는 값을 뺀다" {
            val result = Operator("-").operate(Operand(1), Operand(2))

            result shouldBe Operand(-1)
        }

        "* Operator는 값을 곱한다" {
            val result = Operator("*").operate(Operand(1), Operand(2))

            result shouldBe Operand(2)
        }

        "/ Operator는 값을 나눈 몫을 구한다" {
            val result = Operator("/").operate(Operand(1), Operand(2))

            result shouldBe Operand(0)
        }

        "Operator 는 data 클래스이다" {
            Operator("+") shouldBe Operator("+")
        }
    }
}
