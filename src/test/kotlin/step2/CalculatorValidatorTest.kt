package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class CalculatorValidatorTest : FunSpec({

    context("validateRegex()") {
        test("유효한 계산식이 아닌 경우 예외를 반환한다.") {
            table(
                headers("input"),
                row("3 + + 4"),
                row("+ / * "),
                row("abc"),
                row("3 3")
            ).forAll { input ->
                shouldThrow<IllegalArgumentException> {
                    CalculatorValidator.validateRegex(input)
                }
            }
        }
    }

    context("validateIsNumberOrOperator()") {
        test("숫자나 연산 기호가 아니면 예외를 반환한다.") {
            table(
                headers("{}"),
                row(">"),
                row("!"),
            ).forAll { input ->
                shouldThrow<IllegalArgumentException> {
                    CalculatorValidator.validateIsNumberOrOperator(input)
                }
            }
        }
    }

    context("isNumber()") {
        test("숫자이면 true 를 반환한다.") {
            // given
            val input = "10"
            // when
            val actual = CalculatorValidator.isNumber(input)
            // then
            actual shouldBe true
        }

        test("숫자가 아니면 false 를 반환한다.") {
            // given
            val input = "a"
            // when
            val actual = CalculatorValidator.isNumber(input)
            // then
            actual shouldBe false
        }
    }

    context("isOperator()") {
        test("연산기호이면 true 를 반환한다.") {
            // given
            val input = "+"
            // when
            val actual = CalculatorValidator.isOperator(input)
            // then
            actual shouldBe true
        }

        test("연산기호가 아니면 false 를 반환한다.") {
            // given
            val input = "100"
            // when
            val actual = CalculatorValidator.isOperator(input)
            // then
            actual shouldBe false
        }
    }
})
