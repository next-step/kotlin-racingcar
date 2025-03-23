package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ArithmeticOperatorTest : ShouldSpec({
    context("Create") {
        should("create object from symbol") {
            listOf("+", "-", "*", "/").map {
                ArithmeticOperator.from(it)
            } shouldBe
                listOf(
                    ArithmeticOperator.PLUS,
                    ArithmeticOperator.MINUS,
                    ArithmeticOperator.MULTIPLY,
                    ArithmeticOperator.DIVIDE,
                )
        }

        should("throw exception if not a known symbol") {
            listOf("^", "%", "!", "@", "#", "$").forEach {
                shouldThrow<IllegalArgumentException> {
                    ArithmeticOperator.from(it)
                }
            }
        }
    }

    context("ArithmeticOperations") {
        should("add given values") {
            ArithmeticOperator.PLUS.operate(1, 2) shouldBe 3
        }

        should("subtract given values") {
            ArithmeticOperator.MINUS.operate(5, 2) shouldBe 3
        }

        should("multiply given values") {
            ArithmeticOperator.MULTIPLY.operate(2, 3) shouldBe 6
        }

        should("divide given values") {
            ArithmeticOperator.DIVIDE.operate(6, 3) shouldBe 2
        }

        should("throw exception when division by 0") {
            shouldThrow<IllegalArgumentException> {
                ArithmeticOperator.DIVIDE.operate(10, 0)
            }
        }
    }
})
