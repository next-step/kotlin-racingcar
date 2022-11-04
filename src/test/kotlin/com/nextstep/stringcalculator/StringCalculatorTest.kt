package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.Operator.PLUS
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class StringCalculatorTest : FunSpec({

    test("StringCalculator should take a string expression and split it by ' ' and convert into a list of Element instance") {
        val stringCalculator = StringCalculator("1 + 2")
        stringCalculator.elements shouldContainExactly listOf(Number("1"), PLUS, Number("2"))
    }
})
