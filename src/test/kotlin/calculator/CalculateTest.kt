package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CalculateTest : DescribeSpec({
    lateinit var sut: Calculator

    beforeTest { sut = Calculator(0.0) }

    describe("calculateTest") {
        it("basic add test") {
            val splitFormula: List<String> = listOf("1", "+", "2")
            val actual = sut.execute(splitFormula)
            actual shouldBe 3.0
        }

        it("basic subtract test") {
            val splitFormula: List<String> = listOf("1", "-", "2")
            val actual = sut.execute(splitFormula)
            actual shouldBe -1.0
        }

        it("basic multiply test") {
            val splitFormula: List<String> = listOf("1", "*", "2")
            val actual = sut.execute(splitFormula)
            actual shouldBe 2.0
        }

        it("basic divide test") {
            val splitFormula: List<String> = listOf("1", "/", "2")
            val actual = sut.execute(splitFormula)
            actual shouldBe 0.5
        }
    }

    describe("parseOperator Test") {
        it("when consecutive delimiters, should throw an exception") {
            val operator = "++"
            val ex =
                assertThrows<IllegalArgumentException> {
                    sut.parseOperator(operator)
                }

            ex.message shouldBe "Invalid operator: ++"
        }

        it("parse to ADD") {
            val operator = "+"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(Operator.ADD)
        }

        it("parse to SUBTRACT") {
            val operator = "-"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(Operator.SUBTRACT)
        }

        it("parse to MULTIPLY") {
            val operator = "*"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(Operator.MULTIPLY)
        }

        it("parse to DIVIDE") {
            val operator = "/"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(Operator.DIVIDE)
        }
    }

    describe("parseNumber Test") {
        context("when input can parse to Double") {
            it("should be parse String to Double") {
                val input = "1.0"
                val actual = sut.parseNumber(input)
                actual shouldBe 1.0
            }
        }

        context("when input can not parse to Double") {
            it("should be throw an exception") {
                val input = "abc"
                assertThrows<IllegalArgumentException> {
                    sut.parseNumber(input)
                }
            }
        }
    }
})
