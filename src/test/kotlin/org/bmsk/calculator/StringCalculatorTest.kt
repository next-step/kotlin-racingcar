package org.bmsk.calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    test("plus") {
        StringCalculator.plus("1", "2") shouldBe 3f
    }

    test("minus") {
        StringCalculator.minus("2", "3") shouldBe -1f
    }

    test("multiply") {
        StringCalculator.multiply("3", "3") shouldBe 9f
    }

    test("divide") {
        StringCalculator.divide("6", "4") shouldBe 1.5f
    }
})
