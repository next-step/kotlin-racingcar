package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.Operator.DIVIDE
import com.nextstep.stringcalculator.Operator.MINUS
import com.nextstep.stringcalculator.Operator.MULTIPLY
import com.nextstep.stringcalculator.Operator.PLUS
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class OperatorTest : BehaviorSpec({

    given("Operator.apply(number, number)") {
        `when`("Operator and two numbers are provided") {
            then("calculate the expression") {
                forAll(
                    row(PLUS, 12),
                    row(MINUS, 8),
                    row(MULTIPLY, 20),
                    row(DIVIDE, 5)
                ) { operator, expected ->
                    val actual = operator.calculate(Operand(10), Operand(2))
                    actual.value shouldBe expected
                }
            }
        }
    }

    given("Operator.find(string input)") {
        `when`("string operator is passed") {
            then("Operator Enum will be returned") {
                forAll(
                    row("+", PLUS),
                    row("-", MINUS),
                    row("*", MULTIPLY),
                    row("/", DIVIDE)
                ) { stringOperator, operator ->
                    val result: Operator = Operator.find(stringOperator)
                    result shouldBe operator
                }
            }
        }

        `when`("empty string or something not defined in Operator is passed") {
            then("IllegalArgumentException will be thrown") {
                forAll(
                    row(" "),
                    row("#")
                ) { stringOperator ->
                    shouldThrow<IllegalArgumentException> {
                        Operator.find(stringOperator)
                    } shouldHaveMessage "String operator should be one of (+, -, *, /), it was: $stringOperator"
                }
            }
        }
    }
})
