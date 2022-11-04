package com.nextstep.stringcalculator

import com.nextstep.stringcalculator.Operator.DIVIDE
import com.nextstep.stringcalculator.Operator.MINUS
import com.nextstep.stringcalculator.Operator.MULTIPLY
import com.nextstep.stringcalculator.Operator.PLUS
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

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
})
