package step2

import com.dajeong.step2.StringCalculator
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step2.operator.OperatorSelector

class StringCalculatorTest : StringSpec({

    val stringCalculator = StringCalculator(OperatorSelector())

    "공백 문자열 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("   ")
        }
        exception.message shouldBe "입력값이 비어있습니다. 올바른 값을 입력해주세요."
    }

    "Null 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate(null)
        }
        exception.message shouldBe "입력값이 null 입니다. 올바른 값을 입력해주세요."
    }

    "유효하지 않은 특수문자 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("2 ? 3")
        }
        exception.message shouldBe "연산자 자리에 다른 문자가 입력되었습니다."
    }

    "충분하지 않은 값 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("2 3")
        }
        exception.message shouldBe "계산할 숫자와 연산자가 충분하지 않습니다."
    }

    "숫자 또는 연산자 누락 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("2 + 3 +")
        }
        exception.message shouldBe "숫자 또는 연산자가 누락되었습니다."
    }

    "숫자 자리에 다른 문자열 에러 테스트" {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            stringCalculator.calculate("2 + +")
        }
        exception.message shouldBe "숫자 자리에 다른 문자가 입력되었습니다."
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