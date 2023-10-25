package org.bmsk.calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

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
        }
    }
})
