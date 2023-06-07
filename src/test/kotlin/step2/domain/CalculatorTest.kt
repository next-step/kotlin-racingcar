package step2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step2.model.ErrorCode

class CalculatorTest : DescribeSpec({

    describe(name = "계산기를 실행할 때") {
        context(name = "사칙연산을 섞어 입력하면") {
            val actual = Calculator.calculate(
                calculatorInput = CalculatorInput(
                    numbers = ArrayDeque(
                        elements = listOf(1.0, 2.0, 3.0, 4.0),
                    ),

                    operators = ArrayDeque(
                        elements = listOf(Operator.DIVIDE, Operator.PLUS, Operator.MULTIPLY),
                    ),
                ),
            )

            it(name = "사칙연산에 관계없이 순서대로 계산된다.") {
                actual shouldBe ((1.0 / 2.0) + 3.0) * 4.0
            }
        }

        context(name = "나누기 뒤에 0을 입력하면") {
            val except = 0.0

            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(
                    calculatorInput = CalculatorInput(
                        numbers = ArrayDeque(
                            elements = listOf(1.0, except, 3.0, 4.0),
                        ),

                        operators = ArrayDeque(
                            elements = listOf(Operator.DIVIDE, Operator.PLUS, Operator.MULTIPLY),
                        ),
                    ),
                )
            }

            it(name = "나누기 뒤에 0이 올 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_NUMBER_INPUT_WHEN_DIVIDE.message(except.toString())
            }
        }
    }
})
