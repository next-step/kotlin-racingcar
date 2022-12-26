package step2.calculator.vo

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import step2.calculator.vo.Operation.*

class OperationTest : DescribeSpec({
    table(
        headers("op1", "op2"),
        row(Number(10), Number(5)),
        row(Number(1), Number(5)),
        row(Number(3), Number(3)),
        row(Number(0), Number(1))
    ).forAll { op1, op2 ->
        describe("숫자 ${op1.value}, ${op2.value} 가 주어지고") {
            context("+ 연산자로 계산하면") {
                val actual = PLUS.calculate(op1, op2)
                val expected = op1.value + op2.value

                it("$expected (이)가 반환된다.") {
                    actual shouldBe Number(expected)
                }
            }

            context("- 연산자로 계산하면") {
                val actual = MINUS.calculate(op1, op2)
                val expected = op1.value - op2.value

                it("$expected (이)가 반환된다.") {
                    actual shouldBe Number(expected)
                }
            }

            context("/ 연산자로 계산하면") {
                val actual = DIVIDE.calculate(op1, op2)
                val expected = op1.value / op2.value

                it("$expected (이)가 반환된다.") {
                    actual shouldBe Number(expected)
                }
            }

            context("* 연산자로 계산하면") {
                val actual = MULTI.calculate(op1, op2)
                val expected = op1.value * op2.value

                it("$expected (이)가 반환된다.") {
                    actual shouldBe Number(expected)
                }
            }
        }
    }
})
