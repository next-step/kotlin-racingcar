package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest: StringSpec({

    "(정상 입력)계산기는 계산식 문자열을 입력 받아 결과를 반환한다" {
        forAll<String, Double>(
            row("1 + 1", 2.0),
            row("1 + 1 + 3", 5.0),
            row("2 + 3 * 4 / 2", 10.0),
            row("2 * 3 + 4 / 2", 5.0),
        ) { input, result ->
            StringCalculator.calculate(input) shouldBe result
        }
    }

    "(비정상 입력)계산식 문자열중 숫자가 아닌 문자열이 포함되어 있을 경우 IllegalArgumentException을 던진다" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 + a")
        }
    }

    "(비정상 입력)계산식 문자열중 연속 숫자가 존재하는경우 IllegalArgumentException을 던진다" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 1 +")
        }
    }

    "(비정상 입력)계산식 문자열중 첫 문자가 숫자가 아닌경우 IllegalArgumentException을 던진다" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("+ 1")
        }
    }
})