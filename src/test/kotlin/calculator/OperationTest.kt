package calculator

import calculator.exceptions.NumberSeparationException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe

class OperationTest :
    StringSpec({

        "Addition should return sum of two numbers" {
            Operation.ADD.apply(3.0, 2.0) shouldBeExactly 5.0
        }

        "Subtraction should return difference of two numbers" {
            Operation.SUBTRACT.apply(5.0, 3.0) shouldBeExactly 2.0
        }

        "Multiplication should return product of two numbers" {
            Operation.MULTIPLY.apply(4.0, 2.0) shouldBeExactly 8.0
        }

        "Division should return the quotient of two numbers" {
            Operation.DIVIDE.apply(10.0, 2.0) shouldBeExactly 5.0
        }

        "Division by zero should throw exception" {
            shouldThrow<ArithmeticException> { Operation.DIVIDE.apply(10.0, 0.0) }
        }

        "Parsing a valid operation should return the corresponding enum value" {
            Operation.from("+") shouldBe Operation.ADD
            Operation.from("-") shouldBe Operation.SUBTRACT
            Operation.from("*") shouldBe Operation.MULTIPLY
            Operation.from("/") shouldBe Operation.DIVIDE
        }

        "Parsing an invalid operation should throw NumberSeparationException" {
            shouldThrow<NumberSeparationException> { Operation.from("x") }
            shouldThrow<NumberSeparationException> { Operation.from("%") }
            shouldThrow<NumberSeparationException> { Operation.from("") }
        }
    })
