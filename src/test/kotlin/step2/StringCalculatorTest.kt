package step2

import com.dajeong.step2.StringCalculator
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    val stringCalculator = StringCalculator()

    "공백 문자열 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("   ")
        }
        exception.message shouldBe "입력값이 없습니다."
    }

    "Null 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate(null)
        }
        exception.message shouldBe "입력값이 없습니다."
    }

    "유효하지 않은 특수문자 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("2 ? 3")
        }
        exception.message shouldBe "사칙연산 기호가 아닙니다."
    }

    "덧셈 테스트" {
        val expected = 5
        val actual = stringCalculator.calculate("2 + 3")

        actual shouldBe expected
    }

    "뺄셈 테스트" {
        val expected = -1
        val actual = stringCalculator.calculate("2 - 3")

        actual shouldBe expected
    }

    "나눗셈 테스트" {
        val expected = 0.67
        val actual = stringCalculator.calculate("2 / 3")

        actual shouldBe expected
    }

    "곱셈 테스트" {
        val expected = 6
        val actual = stringCalculator.calculate("2 * 3")

        actual shouldBe expected
    }

    "복합 연산 테스트" {
        val expected = 10
        val actual = stringCalculator.calculate("2 + 3 * 4 / 2")

        actual shouldBe expected
    }
})