package calculator

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : ExpectSpec({

    expect("숫자와 연산자로 이뤄진 계산식을 입력하면 연산 결과를 반환한다.") {
        forAll(
            row(Formula("10 + 10"), 20),
            row(Formula("10 - 10"), 0),
            row(Formula("10 * 10"), 100),
            row(Formula("10 / 10"), 1),
            row(Formula("10 / 10"), 1),
        ) { formula, expected ->
            Calculator.calculate(formula) shouldBe expected
        }
    }

    expect("연산자 우선 순위와 상관없이 순차적으로 연산후 결과를 반환한다.") {
        forAll(
            row(Formula("10 + 10 * 2"), 40),
            row(Formula("10 - 3 * 10"), 70),
        ) { formula, expected ->
            Calculator.calculate(formula) shouldBe expected
        }
    }
})
