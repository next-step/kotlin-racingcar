package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class FormulaTest : ExpectSpec({

    expect("첫 문자가 숫자가 아니면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Formula("a + 1")
        }
    }

    expect("빈 문자열을 입력하면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Formula(" ")
        }
    }

    expect("숫자와 연산자로 이뤄진 문자열을 입력하면 Formula 객체를 생성한다.") {
        val formula = Formula("10 + 10 + 1000")

        formula.initValue shouldBe 10
        formula.tokens shouldBe listOf(FormulaToken("+10"), FormulaToken("+1000"))
    }
})
