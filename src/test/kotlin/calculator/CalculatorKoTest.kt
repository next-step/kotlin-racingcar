package calculator

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
import io.kotest.matchers.shouldNotBe

class CalculatorKoTest : BehaviorSpec() {

    init {
        given("계산기에") {
            `when`("410 + 500 식이 입력 되었다면") {
                then("910.0 결과가 나온다") {
                    Calculator.calculate(PlusFormula) shouldBe PlusResult
                }
            }

            `when`("5090 - 1240 식이 입력 되었다면") {
                then("3850.0 결과가 나온다") {
                    Calculator.calculate(MinusFormula) shouldBe MinusResult
                }
            }

            `when`("9 * 9 식이 입력 되었다면") {
                then("81.0 결과가 나온다") {
                    Calculator.calculate(MultiplyFormula) shouldBe MultiplyResult
                }
            }

            `when`("2304123040 / 25 식이 입력 되었다면") {
                then("92164921.6 결과가 나온다") {
                    Calculator.calculate(DivideFormula) shouldBe DivideResult
                }
            }

            `when`("입력값이 null 이면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        Calculator.calculate(null)
                    }
                    exception shouldNotBe IllegalArgumentException().message
                }
            }

            `when`("입력값이 공백이면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        Calculator.calculate(" ")
                    }
                    exception shouldNotBe IllegalArgumentException().message
                }
            }

            `when`("몽키 테스팅을 했다면") {
                then("에러가 발생한다") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        Calculator.calculate(MonkeyTestFormula)
                    }
                    exception shouldNotBe IllegalArgumentException().message
                }
            }
        }
    }
}