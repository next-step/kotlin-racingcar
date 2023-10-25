package org.bmsk.calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class StringFormulaTest : FunSpec({
    test("plus") {
        StringFormula("1 + 2 + 3").calculate() shouldBe 6f
    }

    test("minus") {
        StringFormula("1 - 2 - 3").calculate() shouldBe -4f
    }

    test("multiply") {
        StringFormula("1 * 2 * 3").calculate() shouldBe 6f
    }

    test("divide") {
        StringFormula("3 / 2 / 1").calculate() shouldBe 1.5f
    }

    test("require IsNotEmpty") {
        shouldThrow<IllegalArgumentException> {
            StringFormula("").calculate()
        }.shouldHaveMessage("공백은 계산할 수 없음")
    }

    test("적절하지 않은 문자열이 포함되었다면 예외") {
        shouldThrow<IllegalArgumentException> {
            StringFormula("4 * 12 = 48").calculate()
        }.shouldHaveMessage("적절하지 않은 문자열: =")
        shouldThrow<IllegalArgumentException> {
            StringFormula("x + x").calculate()
        }.shouldHaveMessage("적절하지 않은 문자열: x")
    }
})
