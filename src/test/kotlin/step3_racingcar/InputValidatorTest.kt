package step3_racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith

class InputValidatorTest : BehaviorSpec({
    val inputValidator = InputValidator()

    given("입력 값이") {
        `when`("null 이거나 공백 또는 빈 문자열일 경우") {
            then("illegalArgumentException 예외를 반환한다.") {
                invalidInputList.forAll {
                    val exception = shouldThrow<IllegalArgumentException> {
                        inputValidator.inputValidate(it)
                    }
                    exception.message should startWith("입력 값은 공백 또는 빈 문자열일 수 없습니다.")
                }
            }
        }

        `when`("숫자가 아닌 문자가 올 경우") {
            then("illegalArgumentException 예외를 반환한다.") {
                notConvertToIntList.forAll {
                    val exception = shouldThrow<IllegalArgumentException> {
                        inputValidator.inputValidate(it)
                    }
                    exception.message should startWith("입력 값은 정수 여야 합니다.")
                }
            }
        }

        `when`("0 이하의 숫자를 입력할 경우") {
            then("illegalArgumentException 예외를 반환한다.") {
                zeroAndNegativeNumberList.forAll {
                    val exception = shouldThrow<IllegalArgumentException> {
                        inputValidator.inputValidate(it)
                    }
                    exception.message should startWith("입력 값은 1 이상이어야 합니다.")
                }
            }
        }
    }
}) {
    companion object {
        private val invalidInputList = listOf(null, "", "   ")
        private val notConvertToIntList = listOf("car", "4.56", "44g6")
        private val zeroAndNegativeNumberList = listOf("-3", "-55", "0")
    }
}
