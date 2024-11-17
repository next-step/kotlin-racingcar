package step2

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

            ex.message shouldBe "invalid operator: ++"
        }

        it("parse to ADD") {
            val operator = "+"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(OperatorType.ADD)
        }

        it("parse to SUBTRACT") {
            val operator = "-"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(OperatorType.SUBTRACT)
        }

        it("parse to MULTIPLY") {
            val operator = "*"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(OperatorType.MULTIPLY)
        }

        it("parse to DIVIDE") {
            val operator = "/"
            val actual = sut.parseOperator(operator)
            actual.shouldBe(OperatorType.DIVIDE)
        }
    }
})
