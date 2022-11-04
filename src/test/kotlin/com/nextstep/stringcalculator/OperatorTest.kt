package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.Operator.DIVIDE
import com.nextstep.stringcalculator.Operator.MINUS
import com.nextstep.stringcalculator.Operator.MULTIPLY
import com.nextstep.stringcalculator.Operator.PLUS
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class OperatorTest : BehaviorSpec({

    given("Operator.apply(number, number)") {
        `when`("PLUS and two numbers are provided") {
            then("plus two numbers") {
                val result: Long = PLUS.apply(10, 2)
                result shouldBe 12
            }
        }

        `when`("MINUS and two numbers are provided") {
            then("minus two numbers") {
                val result: Long = MINUS.apply(10, 2)
                result shouldBe 8
            }
        }

        `when`("MULTIPLY and two numbers are provided") {
            then("multiply two numbers") {
                val result: Long = MULTIPLY.apply(10, 2)
                result shouldBe 20
            }
        }

        `when`("DIVIDE and two numbers are provided") {
            then("divide left number by right number") {
                val result: Long = DIVIDE.apply(10, 2)
                result shouldBe 5
            }
        }
    }

    given("Operator.find(string input)") {
        `when`("'+' is passed") {
            then("PLUS will be returned") {
                val result: Operator = Operator.find("+")
                result shouldBe PLUS
            }
        }

        `when`("'-' is passed") {
            then("MINUS will be returned") {
                val result: Operator = Operator.find("-")
                result shouldBe MINUS
            }
        }

        `when`("'*' is passed") {
            then("MULTIPLY will be returned") {
                val result: Operator = Operator.find("*")
                result shouldBe MULTIPLY
            }
        }

        `when`("'/' is passed") {
            then("DIVIDE will be returned") {
                val result: Operator = Operator.find("/")
                result shouldBe DIVIDE
            }
        }

        `when`("null or empty string is passed") {
            then("IllegalArgumentException will be thrown") {
                shouldThrow<IllegalArgumentException> {
                    Operator.find(" ")
                } shouldHaveMessage "string operator should be one of (+, -, *, /), it was:  "
            }
        }

        `when`("what is not defined in Operator is passed") {
            then("IllegalArgumentException will be thrown") {
                shouldThrow<IllegalArgumentException> {
                    Operator.find("#")
                } shouldHaveMessage "string operator should be one of (+, -, *, /), it was: #"
            }
        }
    }
})
