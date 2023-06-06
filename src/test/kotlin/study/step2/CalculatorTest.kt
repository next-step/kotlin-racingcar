package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "2 + 3 = 5" {
        val calculator = Calculator()
        val result = calculator.execute("2 + 3")
        result shouldBe 5
    }
    "6 - 4 = 2" {
        val calculator = Calculator()
        val result = calculator.execute("6 - 4")
        result shouldBe 2
    }
    "3 * 4 = 12" {
        val calculator = Calculator()
        val result = calculator.execute("3 * 4")
        result shouldBe 12
    }
    "10 / 2 = 5" {
        val calculator = Calculator()
        val result = calculator.execute("10 / 2")
        result shouldBe 5
    }
    "입력값이 null이면 오류가 발생 한다." {
        val calculator = Calculator()
        shouldThrow<IllegalArgumentException> { calculator.execute(null) }
    }
    "입력값이 공백 문자열이면 오류가 발생 한다." {
        val calculator = Calculator()
        shouldThrow<IllegalArgumentException> { calculator.execute("") }
        shouldThrow<IllegalArgumentException> { calculator.execute(" ") }
    }
    "사칙 연산 기호에 해당 하지 않는 문자열이 입력되면 오류가 발생 한다." {
        val calculator = Calculator()
        shouldThrow<IllegalArgumentException> { calculator.execute("2 ? 3") }
    }
})
