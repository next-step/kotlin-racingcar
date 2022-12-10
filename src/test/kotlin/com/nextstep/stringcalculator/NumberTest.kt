package com.nextstep.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberTest : ShouldSpec({

    context("Number constructor") {
        should("parameter should be number in String") {
            val operand = Operand("5")
            operand.value shouldBe 5

            forAll(
                row(""),
                row("+"),
                row("a")
            ) { notANumber ->
                shouldThrow<NumberFormatException> { Operand(notANumber) }
            }
        }
    }

    context("Number operator override") {
        val six = Operand(6)
        val two = Operand(2)

        should("Number(a) + Number(b) should be Number(a+b)") {
            val eight = six + two
            eight shouldBe Operand(6 + 2)
        }

        should("Number(a) - Number(b) should be Number(a-b)") {
            val four = six - two
            four shouldBe Operand(6 - 2)
        }

        should("Number(a) * Number(b) should be Number(a*b)") {
            val twelve = six * two
            twelve shouldBe Operand(6 * 2)
        }

        should("Number(a) / Number(b) should be Number(a/b)") {
            val three = six / two
            three shouldBe Operand(6 / 2)
        }
    }
})
