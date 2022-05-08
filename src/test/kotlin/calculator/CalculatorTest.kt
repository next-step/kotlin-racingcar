package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("execute 메소드") {
        context("+ 연산자를 검증한다.") {
            val operation = Operation.Plus

            it("연산에 성공한다.") {
                val result = operation.execute(2, 1)
                result shouldBe 3
            }
        }

        context("- 연산자를 검증한다.") {
            val operation = Operation.Minus

            it("연산을 성공한다.") {
                val result = operation.execute(2, 1)
                result shouldBe 1
            }
        }

        context("* 연산자를 검증한다.") {
            val operation = Operation.Multiply

            it("연산을 성공한다.") {
                val result = operation.execute(2, 1)
                result shouldBe 2
            }
        }

        context("/ 연산자를 검증한다.") {
            val operation = Operation.Divide

            it("연산을 성공한다.") {
                val result = operation.execute(2, 1)
                result shouldBe 2
            }

            it("분모가 0 일 때 연산을 실패한다.") {
                shouldThrow<IllegalArgumentException> {
                    operation.execute(1, 0)
                }
            }

            it("분자가 0 일 때 연산을 실패한다.") {
                shouldThrow<IllegalArgumentException> {
                    operation.execute(0, 1)
                }
            }

            it("분모, 분자 모두 0 일 때 연산을 실패한다.") {
                shouldThrow<IllegalArgumentException> {
                    operation.execute(0, 0)
                }
            }
        }
    }
})
