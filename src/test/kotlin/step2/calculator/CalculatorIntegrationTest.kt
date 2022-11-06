package step2.calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.doubles.shouldBeExactly
import step2.calculator.system.SystemImpl
import step2.user.UserCleanedInput

/**
 * @see CalculatorImpl
 */
class CalculatorIntegrationTest : ShouldSpec({

    val calculatorSystem = SystemImpl()
    val calculator = CalculatorImpl(calculatorSystem)

    context("숫자 기호 순차 입력을 요청하면") {
        val originalInput = "1 + 5 - 0 * 5 / 7 "
        val cleanedInput = UserCleanedInput.from(originalInput)
        val calculatorInput = CalculatorInput.from(cleanedInput.inputList)
        should("정상 동작한다") {
            val result = shouldNotThrowAny {
                calculator.enter(calculatorInput)
            }
            result.value shouldBeExactly (1.0 + 5.0) * 5 / 7
        }
    }

    context("숫자가 중복된 경우") {
        val originalInput = "1 + 5  1 * 5 / 7 "
        val cleanedInput = UserCleanedInput.from(originalInput)
        val calculatorInput = CalculatorInput.from(cleanedInput.inputList)
        should("이전 결과를 덮어 씌운다.") {
            val result = shouldNotThrowAny {
                calculator.enter(calculatorInput)
            }
            result.value shouldBeExactly 5.0 / 7
        }
    }

    context("문자가 중복된 경우") {
        val originalInput = "1 - + 5 - 0 * 5 / 7 "
        val cleanedInput = UserCleanedInput.from(originalInput)
        val calculatorInput = CalculatorInput.from(cleanedInput.inputList)
        should("이전 함수를 무시한다.") {
            val result = shouldNotThrowAny {
                calculator.enter(calculatorInput)
            }
            result.value shouldBeExactly (1.0 + 5.0) * 5 / 7
        }
    }
})
