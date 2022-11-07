package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class StringCalculatorKoTest : StringSpec({
    val calculator = StringCalculator()

    "덧셈 수식을 계산한다." {
        forAll(
            row("정수의 덧셈", "1 + 2", 3),
            row("음수인 실수가 포함된 덧셈", "-1.2 + 2", 0.8)
        ) { descrption: String, given: String, expected: Number ->
            calculator.calculate(given) shouldBe expected
        }
    }

    "뺄셈 수식을 계산한다." {
        forAll(
            row("정수의 뺄셈", "2 - 1", 1),
            row("음수가 포함된 뺄셈", "-2 - -2", 0),
            row("음수인 실수가 포함된 뺄셈", "-2.1 - 2", -4.1)
        ) { description: String, given: String, expected: Number ->
            calculator.calculate(given) shouldBe expected
        }
    }

    "곱셈 수식을 계산한다." {
        forAll(
            row("정수의 곱셈", "2 * 1", 2),
            row("음수의 곱셈", "-2 * -2", 4),
            row("음수가 포함된 곱셈", "-2 * 2", -4),
            row("음수인 실수가 포함된 뺄셈", "-2.1 * 2", -4.2)
        ) { description: String, given: String, expected: Number ->
            calculator.calculate(given) shouldBe expected
        }
    }

    "나눗셈 수식을 계산한다." {
        forAll(
            row("정수의 나눗셈", "2 / 2", 1),
            row("음수의 나눗셈", "-2 / -2", 1),
            row("음수가 포함된 나눗셈", "-2 / 2", -1),
            row("음수인 실수가 포함된 나눗셈", "-2.1 / 2", -1.05)
        ) { description: String, given: String, expected: Number ->
            calculator.calculate(given) shouldBe expected
        }
    }

    "사칙 연산을 모두 포함한 표현식을 계산한다." {
        val given = "1 - 2 + 3 * 4 / 5"
        val actual = calculator.calculate(given)
        actual shouldBe 1.6
    }

    "입력값이 유효하지 않은 경우 경우 예외가 발생한다." {
        forAll(
            row("빈값", ""),
            row("공백", ""),
            row("공백으로 구분되지 않은 경우", "1+1"),
            row("계산 항목이 부족한 표현식", " 1 "),
            row("계산 항목이 포함되지 않은 표현식", " +++ "),
            row("계산 항목이 올바르지 않은 표현식", " 1++ "),
            row("계산 항목이 올바르지 않은 표현식", " +1+ "),
        ) { description: String, given: String ->
            shouldThrow<IllegalArgumentException> {
                calculator.calculate(given)
            }
        }
    }
})
