package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class FormulaTokenTest : ExpectSpec({

    expect("첫번째 문자가 연산자이고 두번째 문자가 숫자이면 FormulaToken 객체를 생성한다.") {
        val formulaToken = FormulaToken("+1")

        formulaToken.operator shouldBe Operator.PLUS
        formulaToken.operand shouldBe 1
    }

    expect("첫번째 문자가 연산자가 아니면 예외가 발생한다") {
        shouldThrow<IllegalArgumentException> {
            FormulaToken("1 ")
        }
    }

    expect("두번째 문자가 숫자가 아니면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            FormulaToken("+a")
        }
    }
})
