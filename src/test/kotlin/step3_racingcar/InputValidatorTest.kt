package step3_racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import step3_racingcar.validator.InputValidator

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

        `when`("양의 정수를 입력할 경우") {
            then("입력한 값이 Int 타입으로 반환된다.") {
                positiveNumberList.forAll {
                    inputValidator.inputValidate(it) shouldBe it.toIntOrNull()
                }
            }
        }
    }
}) {
    companion object {
        private val invalidInputList = listOf(null, "", "   ")
        private val notConvertToIntList = listOf("car", "4.56", "44g6")
        private val zeroAndNegativeNumberList = listOf("-3", "-55", "0")
        private val positiveNumberList = listOf("1", "5", "100")
    }
}
