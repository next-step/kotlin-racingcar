package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class NumberTest : ShouldSpec({

    context("Number constructor") {
        should("parameter should be number in String") {
            val operand = Operand("5")
            operand.value shouldBe 5

            shouldThrow<NumberFormatException> { Operand("") }
            shouldThrow<NumberFormatException> { Operand("+") }
            shouldThrow<NumberFormatException> { Operand("a") }
        }
    }

    context("Number operator override") {
        should("Numbers can be calculated by +, -, *, / operator") {
            val six = Operand(6)
            val two = Operand(2)

            val eight = six + two
            val four = six - two
            val twelve = six * two
            val three = six / two

            eight shouldBe Operand(8)
            four shouldBe Operand(4)
            twelve shouldBe Operand(12)
            three shouldBe Operand(3)
        }
    }
})
