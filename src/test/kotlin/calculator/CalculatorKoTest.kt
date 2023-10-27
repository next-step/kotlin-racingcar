package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy

class CalculatorKoTest : StringSpec({
    "1 + 2의 결과는 3이다" {
        val result = Calculator.execute("1 + 2")

        result shouldBe 3
    }

    "2 - 1의 결과는 1이다" {
        val result = Calculator.execute("2 - 1")

        result shouldBe 1
    }

    "2 * 3의 결과는 6이다" {
        val result = Calculator.execute("2 * 3")

        result shouldBe 6
    }

    "4 / 2의 결과는 2이다" {
        val result = Calculator.execute("4 / 2")

        result shouldBe 2
    }

    "4 * 2 + 2 / 10의 결과는 1이다" {
        val result = Calculator.execute("4 * 2 + 2 / 10")

        result shouldBe 1
    }

    "빈 문자열을 요청하면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "null 문자열을 요청하면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "숫자만 요청하면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("1")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "연산자만 요청하면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("+")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "수식에 오류가 있으면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("1 + ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "연산자 위치에 연산자가 아닌 값이 있으면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("1 a 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "숫자 위치에 숫자가 아닌 값이 있으면 오류를 반환한다" {
        assertThatThrownBy {
            Calculator.execute("a + 1 ")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
})
