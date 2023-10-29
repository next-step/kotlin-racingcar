package calculator

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class CalculatorKoTest : StringSpec({
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
