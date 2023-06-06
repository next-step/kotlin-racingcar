package step2.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    describe(name = "계산기를 실행할 때") {
        context(name = "사칙연산을 섞어 입력하면") {
            val actual = Calculator.calculate(
                calculatorInput = CalculatorInput(
                    numbers = ArrayDeque(
                        elements = listOf(1L, 2L, 3L, 4L),
                    ),

                    operators = ArrayDeque(
                        elements = listOf(Operator.DIVIDE, Operator.PLUS, Operator.MULTIPLY),
                    ),
                ),
            )

            it(name = "사칙연산에 관계없이 순서대로 계산된다.") {
                actual shouldBe ((1 / 2) + 3) * 4
            }
        }

        context(name = "허용된 범위를 넘어간 값을 입력하면") {
            val actual = Calculator.calculate(
                calculatorInput = CalculatorInput(
                    numbers = ArrayDeque(
                        elements = listOf(
                            10000000L,
                            10000000L,
                            1000000000L,
                            100000000L,
                            10000000000L,
                            10000000L,
                            10000000L,
                            1000000000L,
                            100000000L,
                            10000000000L,
                            10000000L,
                            10000000L,
                            1000000000L,
                            100000000L,
                            10000000000L,
                            10000000L,
                            10000000L,
                            1000000000L,
                            100000000L,
                            10000000000,
                        ),
                    ),

                    operators = ArrayDeque(
                        elements = listOf(
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                            Operator.MULTIPLY,
                        ),
                    ),
                ),
            )

            it(name = "0이 반환된다.") {
                actual shouldBe 0
            }
        }
    }
})
