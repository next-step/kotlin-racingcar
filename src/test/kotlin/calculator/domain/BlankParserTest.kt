package calculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class BlankParserTest : StringSpec() {
    init {
        "연산자를 파싱한다" {
            val parser = BlankParser()

            val operators = parser.parseOperators("3 + 6 * 2 / 3")

            operators.poll() shouldBe Operator("+")
            operators.poll() shouldBe Operator("*")
            operators.poll() shouldBe Operator("/")
        }

        "피연산자를 파싱한다" {
            val parser = BlankParser()

            val operands = parser.parseOperands("3 + 6 * 2 / 3")

            operands.poll() shouldBe Operand("3")
            operands.poll() shouldBe Operand("6")
            operands.poll() shouldBe Operand("2")
            operands.poll() shouldBe Operand("3")
        }
    }
}
