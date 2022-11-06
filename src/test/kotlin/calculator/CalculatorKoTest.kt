package calculator

import calculator.model.ComplexOperation
import calculator.model.ComplexOperationResult
import calculator.model.DivideFormula
import calculator.model.DivideResult
import calculator.model.MinusFormula
import calculator.model.MinusResult
import calculator.model.MultiplyFormula
import calculator.model.MultiplyResult
import calculator.model.PlusFormula
import calculator.model.PlusResult
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
        }

        given("계산기에 5090 - 1240 식이 입력 되었고") {
            beforeEach { expression = Expression(MinusFormula) }
            `when`("연산식을 계산하면") {
                then("3850.0 결과가 나온다") {
                    val (numbers, operators) = expression.partitionExpression()
                    calculator.calculate(numbers, operators) shouldBe MinusResult
                }
            }
        }

        given("계산기에 9 * 9 식이 입력 되고") {
            beforeEach { expression = Expression(MultiplyFormula) }
            `when`("연산식을 계산하면") {
                then("81.0 결과가 나온다") {
                    val (numbers, operators) = expression.partitionExpression()
                    calculator.calculate(numbers, operators) shouldBe MultiplyResult
                }
            }
        }

        given("계산기에 2304123040 / 25 식이 입력 되고") {
            beforeEach { expression = Expression(DivideFormula) }
            `when`("연산식을 계산하면") {
                then("92164921.6 결과가 나온다") {
                    val (numbers, operators) = expression.partitionExpression()
                    calculator.calculate(numbers, operators) shouldBe DivideResult
                }
            }
        }

        given("계산기에 2 + 3 * 4 / 2 식이 입력 되었고") {
            beforeEach { expression = Expression(ComplexOperation) }
            `when`("연산식을 계산하면") {
                then("10.0 결과가 나온다") {
                    val (numbers, operators) = expression.partitionExpression()
                    calculator.calculate(numbers, operators) shouldBe ComplexOperationResult
                }
            }
        }
    }
}
