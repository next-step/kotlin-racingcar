package step2.calculator.vo

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorInputKtTest : DescribeSpec({

    table(
        headers("input", "type"),
        row("+", Operation::class.java),
        row("-", Operation::class.java),
        row("*", Operation::class.java),
        row("/", Operation::class.java),
        row("1234", Number::class.java),
        row("4334", Number::class.java),
        row("124", Number::class.java),
        row("12235", Number::class.java),
    ).forAll { input, expected ->
        describe("CalculatorInput에 입력값 $input 을 넣고") {
            val calculatorInput = CalculatorInput.from(input)

            context("$expected 타입을 반환하는지 확인하면") {
                val actual = calculatorInput.javaClass.isAssignableFrom(expected)

                it("성공한다.") {
                    actual shouldBe true
                }
            }
        }
    }

    listOf(
        "ㅂ",
        "-4f3",
        "*d",
        "/2",
        "123sd4",
        "4_334",
        "12d4",
        "122a35",
    ).forAll { input ->
        describe("CalculatorInput에 입력값 $input 을 넣고") {
            context("성공을 확인하면") {
                it("실패한다.") {
                    shouldThrowAny {
                        CalculatorInput.from(input)
                    }
                }
            }
        }
    }
})
