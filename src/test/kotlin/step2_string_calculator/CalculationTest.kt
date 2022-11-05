package step2_string_calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step2_string_calculator.Calculation.Companion.calculate
import step2_string_calculator.Calculation.Companion.isValid

class CalculationTest : StringSpec({
    "두 입력 값을 더한 결과가 올바르다." {
        val result = calculate(1, 2, '+')
        result shouldBe 3
    }

    "두 입력 값을 뺀 결과가 올바르다." {
        val result = calculate(5, 3, '-')
        result shouldBe 2
    }

    "두 입력 값을 곱한 결과가 올바르다." {
        val result = calculate(5, 3, '*')
        result shouldBe 15
    }

    "두 입력 값을 나눈 결과가 올바르다." {
        val result = calculate(9, 3, '/')
        result shouldBe 3
    }

    "사칙연산의 기호가 아니라면 false 를 리턴한다." {
        val isValid = isValid('&')
        isValid shouldBe false
    }
})
