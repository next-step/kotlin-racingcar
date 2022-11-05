package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumberTest : ShouldSpec({

    context("Number constructor") {
        should("parameter should be number in String") {
            val number = Number("5")
            number.value shouldBe 5

            shouldThrow<NumberFormatException> { Number("") }
            shouldThrow<NumberFormatException> { Number("+") }
            shouldThrow<NumberFormatException> { Number("a") }
        }
    }

    context("Number operator override") {
        should("Numbers can be calculated by +, -, *, / operator") {
            val six = Number(6)
            val two = Number(2)

            val eight = six + two
            val four = six - two
            val twelve = six * two
            val three = six / two

            eight shouldBe Number(8)
            four shouldBe Number(4)
            twelve shouldBe Number(12)
            three shouldBe Number(3)
        }
    }
})
