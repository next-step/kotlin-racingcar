package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class StringCalculatorTest : ShouldSpec({
    context("InputValidation") {
        should("throw exception if null or empty") {
            listOf("", " ", null).forAll {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator("")
                }
            }
        }

        should("throw exception if split strings are less than 3") {
            listOf("12 34", "12 +", "+ +").forAll {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(it)
                }
            }
        }

        should("contain at least 3 split strings") {
            listOf("12 + 56", "12  + 56", "12 + 34", "12 + 34").forAll {
                shouldNotThrowAny {
                    StringCalculator(it)
                }
            }
        }
    }

    context("ParseSplitInput") {
        should("not throw exception if expression is correct") {
            listOf(
                "1 + 2",
                "1 + 2 + 3",
                "1 + 2 / 2 * 5",
                "5 - 1 * 2 / 4",
            ).forAll {
                shouldNotThrowAny {
                    StringCalculator(it)
                }
            }
        }

        should("throw exception if expression is wrong") {
            listOf(
                "1 + 2 +",
                "+ 1 + 11 / 2",
                "10 - 5 * 2 +",
                "* 1 + 3 / 2 +",
            ).forAll {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(it)
                }
            }
        }
    }

    context("Calculation") {
        context("Addition") {
            should("add all input values") {
                listOf(
                    "1 + 4",
                    "2 + 3",
                    "2 + 2 + 1",
                    "4 + 1",
                ).forAll {
                    StringCalculator(it).calculate() shouldBe 5
                }
            }
        }

        context("Subtraction") {
            should("subtract all input values") {
                listOf(
                    "15 - 14",
                    "6 - 2 - 3",
                    "10 - 2 - 7",
                ).forAll {
                    StringCalculator(it).calculate() shouldBe 1
                }
            }
        }

        context("Multiplication") {
            should("multiply all input values") {
                listOf(
                    "2 * 3",
                    "6 * 2 * 4",
                    "1 * 23 * 5 * 0",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(6, 48, 0)
            }
        }

        context("Division") {
            should("divide all input values") {
                listOf(
                    "36 / 6",
                    "100 / 5 / 20",
                    "72 / 8 / 3",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(6, 1, 3)
            }

            should("throw exception if division by 0") {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator("24 / 12 / 0").calculate()
                }
            }
        }

        context("ComplexExpression") {
            should("calculate complex expressions") {
                listOf(
                    "2 + 6 / 2",
                    "36 / 6 * 2 + 3",
                    "88 / 22 + 3 * 6",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(4, 15, 42)
            }
        }
    }

    context("LearningTests") {
        context("Inspectors") {
            should("calculate complex expressions") {
                listOf(
                    "2 + 6 / 2" to 4,
                    "36 / 6 * 2 + 3" to 15,
                    "88 / 22 + 3 * 6" to 42,
                ).forAll { (expression, expected) ->
                    StringCalculator(expression).calculate() shouldBe expected
                }
            }
        }

        context("Data Tests with should-withData") {
            should("calculate complex expressions") {
                this@context.withData(
                    "2 + 6 / 2" to 4,
                    "36 / 6 * 2 + 3" to 15,
                    "88 / 22 + 3 * 6" to 42,
                ) { (expression, expected) ->
                    StringCalculator(expression).calculate() shouldBe expected
                }
            }
        }

        context("Data Tests with withData") {
            withData(
                "2 + 6 / 2" to 4,
                "36 / 6 * 2 + 3" to 15,
                "88 / 22 + 3 * 6" to 42,
            ) { (expression, expected) ->
                StringCalculator(expression).calculate() shouldBe expected
            }
        }
    }
})
