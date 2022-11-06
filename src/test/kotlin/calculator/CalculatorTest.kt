package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class CalculatorTest : StringSpec({

    "계산한다 " {
        val sut = Calculator()
        val result = sut.calculate("2 + 3 * 4 / 2")

        result shouldBe "10"
    }

    "계산한다 2" {
        val sut = Calculator()
        val result = sut.calculate("1 + 2 - 1")

        result shouldBe "2"
    }

    "계산한다 3" {

        val sut = Calculator()
        val result = sut.calculate("10 * 10 * 10")

        result shouldBe "1000"
    }

    "소숫점자리를 절삭한 결과를 반환한다 " {
        val sut = Calculator()
        val result = sut.calculate("3 / 1")

        result shouldBe "3"
    }

    "지원하지 않는 사칙연산을 포함하면 실패한다" {
        val sut = Calculator()

        assertThatThrownBy {
            sut.calculate("1 + 2 ! 1")
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Unsupported Operator [!]")
    }

    "지원하지 않는 숫자범위를 포함하면 실패한다" {
        val sut = Calculator()

        assertThatThrownBy {
            sut.calculate("1 + 2 ! 1")
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Unsupported Operator [!]")
    }

    "Division By Zero 발생시 실패 " {
        val sut = Calculator()

        shouldThrowExactly<ArithmeticException> {
            sut.calculate("3 / 0")
        }
    }

    "오버 플로우 발생시에 실패 " {
        val sut = Calculator()
        val maxVal = Long.MAX_VALUE.toString()

        shouldThrowExactly<ArithmeticException> {
            sut.calculate(maxVal + " + " + maxVal)
        }
    }

    "언더 플로우 발생시에 실패한다" {
        val sut = Calculator()
        val minVal = Long.MIN_VALUE.toString()

        shouldThrowExactly<ArithmeticException> {
            sut.calculate(minVal + " + " + minVal)
        }
    }

    "operand 는 숫자여야한다 " {
        val sut = Calculator()
        assertThatThrownBy {
            sut.calculate("2a + 3")
        }.isExactlyInstanceOf(NumberFormatException::class.java)
    }

    "operator, operator 짝이 맞아야한다" {
        val sut = Calculator()

        assertThatThrownBy {
            sut.calculate("2 + 1 +")
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid Input")
    }

    "모든 operand 는 Long 범위 안의 숫자여야한다" {
        val sut = Calculator()
        assertThatThrownBy {
            sut.calculate("9223372036854775809 + 3")
        }.isExactlyInstanceOf(NumberFormatException::class.java)
    }

    "operator 가 없는 경우 바로 반환한다" {
        val sut = Calculator()

        sut.calculate("2") shouldBe "2"
    }
})
