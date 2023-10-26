package org.bmsk.calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.bmsk.calculator.ErrorMessage.BLANK_FORMULA
import org.bmsk.calculator.ErrorMessage.DIVISION_BY_ZERO
import org.bmsk.calculator.ErrorMessage.EVEN_POSITION_MUST_BE_NUMBER
import org.bmsk.calculator.ErrorMessage.FORMULA_MUST_END_WITH_NUMBER
import org.bmsk.calculator.ErrorMessage.FORMULA_MUST_START_WITH_NUMBER
import org.bmsk.calculator.ErrorMessage.ODD_POSITION_MUST_BE_OPERATOR

class StringFormulaTest : FunSpec({
    context("Run All Test") {

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

        test("0으로 나눌 경우 예외") {
            shouldThrow<IllegalArgumentException> {
                StringFormula("3 / 0").calculate()
            }.shouldHaveMessage(DIVISION_BY_ZERO)
        }

        test("빈 문자열인 경우") {
            shouldThrow<IllegalArgumentException> {
                StringFormula("").calculate()
            }.shouldHaveMessage(BLANK_FORMULA)
        }

        test("적절하지 않은 문자열이 포함된 경우") {
            shouldThrow<IllegalArgumentException> {
                StringFormula("4 * 12 = 48").calculate()
            }.shouldHaveMessage(ODD_POSITION_MUST_BE_OPERATOR)
            shouldThrow<IllegalArgumentException> {
                StringFormula("1 + x + 1").calculate()
            }.shouldHaveMessage(EVEN_POSITION_MUST_BE_NUMBER)
            shouldThrow<IllegalArgumentException> {
                StringFormula("x + x").calculate()
            }.shouldHaveMessage(FORMULA_MUST_START_WITH_NUMBER)
            shouldThrow<IllegalArgumentException> {
                StringFormula("1 + x").calculate()
            }.shouldHaveMessage(FORMULA_MUST_END_WITH_NUMBER)
        }

        test("마지막에 수가 아니라 문자가 오는 경우") {
            shouldThrow<IllegalArgumentException> {
                StringFormula("1 + ").calculate()
            }.shouldHaveMessage(FORMULA_MUST_END_WITH_NUMBER)
            shouldThrow<IllegalArgumentException> {
                StringFormula("1 +").calculate()
            }.shouldHaveMessage(FORMULA_MUST_END_WITH_NUMBER)
        }
    }
})
