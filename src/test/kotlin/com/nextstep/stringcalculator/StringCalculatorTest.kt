package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.Operator.PLUS
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.throwable.shouldHaveMessage

class StringCalculatorTest : FunSpec({

    test("StringCalculator should take a string expression and split it by ' ' and convert into a list of Element instance") {
        val stringCalculator = StringCalculator("1 + 2")
        stringCalculator.elements shouldContainExactly listOf(Number("1"), PLUS, Number("2"))
    }

    test("If StringCalculator take empty string, throw IllegalArgumentException") {
        shouldThrow<IllegalArgumentException> {
            StringCalculator(" ")
        } shouldHaveMessage "Input shouldn't be blank"
    }
})
