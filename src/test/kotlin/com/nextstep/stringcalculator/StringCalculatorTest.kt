package com.nextstep.stringcalculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class StringCalculatorTest : FunSpec({

    test("StringCalculator should take a string expression and split it by ' '") {
        val stringCalculator = StringCalculator("1 + 2")
        stringCalculator.elements shouldContainExactly listOf("1", "+", "2")
    }
})
