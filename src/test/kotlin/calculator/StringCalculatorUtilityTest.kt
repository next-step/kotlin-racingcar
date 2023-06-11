package calculator

import calculator.StringCalculatorUtility.Companion.calculatedNumber
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("문자열 계산기 유틸리티")
class StringCalculatorUtilityTest : StringSpec({

    "숫자 문자열의 사칙연산 계산" {
        listOf(
            "2 + 3 * 4 / 2" to 10,
            "5 - 1 / 2 + 3 * 3" to 15
        ).forAll {
            it.first.calculatedNumber() shouldBe it.second
        }
    }

    "입력 값이 null 이거나 빈 공백이면 IllegalArgumentException" {
        listOf(null, "").forAll {
            shouldThrowExactly<IllegalArgumentException> {
                it.calculatedNumber()
            }
        }
    }

    "사칙 연산 기호가 아니라면 IllegalArgumentException" {
        listOf("1 ! 1", "1 @ 1", "1 # 1", "1 = 1").forAll {
            shouldThrowExactly<IllegalArgumentException> {
                it.calculatedNumber()
            }
        }
    }
})
