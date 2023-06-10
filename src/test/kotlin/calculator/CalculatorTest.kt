package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "덧셈" {
        Calculator().calculate("1 + 2") shouldBe 3
    }

    "뺄셈" {
        Calculator().calculate("1 - 2") shouldBe -1
    }

    "곱셈" {
        Calculator().calculate("1 * 2") shouldBe 2
    }

    "나눗셈" {
        Calculator().calculate("1 / 2") shouldBe 0
    }

    "입력값이 공백이면 예외 발생" {
        forAll(
            row(""),
            row(" "),
        ) { expression ->
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator().calculate(expression)
            }
            exception.message shouldBe "입력값이 공백입니다."
        }
    }

    "사칙연산 기호가 아니면 예외 발생" {
        forAll(
            row("1 ! 2"),
            row("1 % 2"),
            row("1 ^ 2"),
            row("1 & 2"),
        ) { expression ->
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator().calculate(expression)
            }

            val operator = expression[2]
            exception.message shouldBe "사칙연산 기호가 올바르지 않습니다. : $operator"
        }
    }

    "입력 여러 개일 때 계산" {
        forAll(
            row("2 + 3 * 4 / 2", 10),
            row("2 * 3 - 4 / 2", 1),
            row("2 - 3 / 4 + 2", 2),
        ) { expression, answer ->
            Calculator().calculate(expression) shouldBe answer
        }
    }
})
