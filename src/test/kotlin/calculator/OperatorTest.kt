package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({

    "사칙연산 문자열로 Operator 객체 생성" {
        forAll(
            row("+", Operator.ADD),
            row("-", Operator.SUBTRACT),
            row("*", Operator.MULTIPLY),
            row("/", Operator.DIVIDE),
        ) { symbol, operator ->
            Operator.of(symbol) shouldBe operator
        }
    }

    "사칙연산 문자열이 올바르지 않으면 예외 발생" {
        forAll(
            row("!"),
            row("%"),
            row("^"),
            row("&"),
        ) {
            val exception = shouldThrow<IllegalArgumentException> {
                Operator.of(it)
            }

            exception.message shouldBe "사칙연산 기호가 올바르지 않습니다. : $it"
        }
    }

    "덧셈" {
        Operator.ADD.operate(1, 2) shouldBe 3
    }

    "뺄셈" {
        Operator.SUBTRACT.operate(1, 2) shouldBe -1
    }

    "곱셈" {
        Operator.MULTIPLY.operate(1, 2) shouldBe 2
    }

    "나눗셈" {
        Operator.DIVIDE.operate(1, 2) shouldBe 0
    }

    "0으로 나누면 에외 발생" {
        val exception = shouldThrow<IllegalArgumentException> {
            Operator.DIVIDE.operate(1, 0)
        }
        exception.message shouldBe "0으로 나눌 수 없습니다."
    }
})
