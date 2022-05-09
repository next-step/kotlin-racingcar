package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTest : StringSpec({
    "더하기" {
        val calculator = Calculator()

        calculator.plus(2, 1) shouldBe 3
    }

    "빼기" {
        val calculator = Calculator()

        calculator.minus(2, 1) shouldBe 1
    }

    "곱하기" {
        val calculator = Calculator()

        calculator.multiply(2, 3) shouldBe 6
    }

    "나누기" {
        val calculator = Calculator()

        calculator.division(8, 2) shouldBe 4
    }

    "사칙연산 기호가 아닌 경우 에러가 발생한다" {
        val calculator = Calculator()

        val exception = shouldThrow<IllegalArgumentException> {
            calculator.calculate("1 , 1")
        }

        exception.message shouldBe "잘못된 사칙연산 기호입니다."
    }

    "입력값이 빈 공백일 경우 에러가 발생한다" {
        val calculator = Calculator()

        shouldThrow<IllegalArgumentException> {
            calculator.calculate("")
        }.message shouldBe "잘못된 입력값입니다."

        shouldThrow<IllegalArgumentException> {
            calculator.calculate(" ")
        }.message shouldBe "잘못된 입력값입니다."

        shouldThrow<IllegalArgumentException> {
            calculator.calculate("\t")
        }.message shouldBe "잘못된 입력값입니다."

        shouldThrow<IllegalArgumentException> {
            calculator.calculate("\n")
        }.message shouldBe "잘못된 입력값입니다."
    }

    "사칙연산 문자열을 받아 계산한 값을 반환한다" {
        val calculator = Calculator()

        calculator.calculate("2 + 9 - 1 * 10 / 5") shouldBe 20
    }
})
