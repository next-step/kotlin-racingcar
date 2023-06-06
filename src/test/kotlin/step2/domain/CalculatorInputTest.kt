package step2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step2.model.ErrorCode

class CalculatorInputTest : DescribeSpec({

    describe(name = "CalculatorInput 생성할 때") {
        val numbers = ArrayDeque(
            elements = listOf(1L, 2L, 3L),
        )

        val operators = ArrayDeque(
            elements = listOf(Operator.DIVIDE, Operator.PLUS),
        )

        context(name = "정상적으로 값을 넣으면") {
            val calculatorInput = CalculatorInput(
                numbers = numbers,
                operators = operators,
            )

            it(name = "생성된다.") {
                calculatorInput.numbers shouldBe numbers
                calculatorInput.operators shouldBe operators
            }
        }

        context(name = "연산자와 숫자의 값을 동일하게 넣으면") {
            numbers.removeFirst()

            val exception = shouldThrow<IllegalArgumentException> {
                CalculatorInput(
                    numbers = numbers,
                    operators = operators,
                )
            }

            it(name = "생성하지 못하고, 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_CALCULATOR_INPUT.message(
                    "${numbers.size} ${operators.size}"
                )
            }
        }
    }
})
