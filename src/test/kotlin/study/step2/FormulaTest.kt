package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class FormulaTest : StringSpec({
    "Null이 입력될 경우 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> {
            Formula(null)
        }.shouldHaveMessage("잘못된 연산자입니다.")
    }

    "공백 문자열이 입력될 경우 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> {
            Formula(" ")
        }.shouldHaveMessage("잘못된 연산자입니다.")
    }

    "정상적인 식이 입력될 경우 객체가 정상적으로 생성된다" {
        val formula = Formula("2 + 3 * 4 / 2")

        formula.expression[0] shouldBe "2"
        formula.expression[1] shouldBe "+"
        formula.expression[2] shouldBe "3"
        formula.expression[3] shouldBe "*"
        formula.expression[4] shouldBe "4"
        formula.expression[5] shouldBe "/"
        formula.expression[6] shouldBe "2"
    }
})
