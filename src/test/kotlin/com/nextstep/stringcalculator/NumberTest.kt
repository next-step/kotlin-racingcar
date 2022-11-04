package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumberTest : ShouldSpec({

    context("Number constructor") {
        should("parameter should be number in String") {
            val number = Number("5")
            number.number shouldBe 5

            shouldThrow<NumberFormatException> { Number("") }
            shouldThrow<NumberFormatException> { Number("+") }
            shouldThrow<NumberFormatException> { Number("a") }
        }
    }
})
