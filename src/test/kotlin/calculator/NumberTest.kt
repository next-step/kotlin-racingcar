package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "숫자가 아닌 문자입력시 오류 발생" {
        val exception = shouldThrow<IllegalArgumentException> {
            Number("a")
        }
        exception.message shouldBe "숫자가 아닌 문자열 입니다."
    }

    "덧셈 테스트" {
        val a = Number(6)
        val b = Number(3)
        val plus = a.sum(b)
        plus shouldBe Number(9)
    }

    "뺄셈 테스트" {
        val a = Number(6)
        val b = Number(3)
        val minus = a.subtract(b)
        minus shouldBe Number(3)
    }

    "곱셈 테스트" {
        val a = Number(6)
        val b = Number(3)
        val multiply = a.times(b)
        multiply shouldBe Number(18)
    }

    "나눗셈 테스트" {
        val a = Number(6)
        val b = Number(3)
        val divide = a.div(b)
        divide shouldBe Number(2)
    }
})