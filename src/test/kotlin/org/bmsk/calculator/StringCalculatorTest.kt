package org.bmsk.calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    test("plus") {
        StringCalculator.plus("1", "2") shouldBe "3.0"
    }

    test("minus") {
        StringCalculator.minus("2", "3") shouldBe "-1.0"
    }

    test("multiply") {
        StringCalculator.multiply("3", "3") shouldBe "9.0"
    }

    test("divide") {
        StringCalculator.divide("6", "4") shouldBe "1.5"
    }
})
