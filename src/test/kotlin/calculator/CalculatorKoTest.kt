package calculator

import calculator.model.ComplexOperation
import calculator.model.ComplexOperationResult
import calculator.model.DivideFormula
import calculator.model.DivideResult
import calculator.model.MinusFormula
import calculator.model.MinusResult
import calculator.model.MonkeyTestFormula
import calculator.model.MultiplyFormula
import calculator.model.MultiplyResult
import calculator.model.PlusFormula
import calculator.model.PlusResult
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorKoTest : BehaviorSpec() {

    lateinit var calculator: Calculator
    lateinit var expression: Expression

    init {
        beforeEach {
            calculator = Calculator()
        }

        given("계산기에 410 + 500 식이 입력 되었고") {
            beforeEach { expression = Expression(PlusFormula) }
            `when`("연산식을 계산을 하면") {
                then("910.0 결과가 나온다") {
                    val (numbers, operators) = expression.partitionExpression()
                    calculator.calculate(numbers, operators) shouldBe PlusResult
                }
            }

            `xwhen`("5090 - 1240 식이 입력 되었다면") {
                then("3850.0 결과가 나온다") {
//                    calculator.calculate(MinusFormula) shouldBe MinusResult
                }
            }

            `xwhen`("9 * 9 식이 입력 되었다면") {
                then("81.0 결과가 나온다") {
//                    calculator.calculate(MultiplyFormula) shouldBe MultiplyResult
                }
            }

            `xwhen`("2304123040 / 25 식이 입력 되었다면") {
                then("92164921.6 결과가 나온다") {
//                    calculator.calculate(DivideFormula) shouldBe DivideResult
                }
            }

            `xwhen`("2 + 3 * 4 / 2 식이 입력 되었다면") {
                then("10.0 결과가 나온다") {
//                    calculator.calculate(ComplexOperation) shouldBe ComplexOperationResult
                }
            }

            `xwhen`("입력값이 null 이면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
//                        calculator.calculate(null)
                    }
                    exception.message shouldBe "Failed requirement."
                }
            }

            `xwhen`("입력값이 공백이면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
//                        calculator.calculate(" ")
                    }
                    exception.message shouldBe "Failed requirement."
                }
            }

            `xwhen`("몽키 테스팅을 했다면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
//                        calculator.calculate(MonkeyTestFormula)
                    }
                    exception.message shouldBe "Failed requirement."
                }
            }
        }
    }
}
