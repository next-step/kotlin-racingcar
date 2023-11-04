package racingcar.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class RacingcarGameInputValidatorTest : FunSpec({
    val racingcarGameInputValidator = RacingcarGameInputValidator()

    context("자동차 이름 입력 예외 테스트") {
        test("자동차 이름 문자열이 null인 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val carNamesString = null

                racingcarGameInputValidator.validateCarNamesString(carNamesString)
            }
        }

        test("자동차 이름이 공백인 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val carName = ""

                racingcarGameInputValidator.validateCarName(carName)
            }
        }

        test("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val carName = "testNameLengthMoreThan5"

                racingcarGameInputValidator.validateCarName(carName)
            }
        }
    }

    context("게임 횟수 입력 테스트") {
        test("게임 횟수 문자열이 null 인 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val roundsString = null

                racingcarGameInputValidator.validateRoundNumberString(roundsString)
            }
        }

        test("게임 횟수 문자열이 0인 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val roundsString = "0"

                racingcarGameInputValidator.validateRoundNumberString(roundsString)
            }
        }

        test("게임 횟수 문자열이 음수인 경우 IllegalArgumentException 예외가 발생한다.") {
            shouldThrow<IllegalArgumentException> {
                val roundsString = "-1"

                racingcarGameInputValidator.validateRoundNumberString(roundsString)
            }
        }
    }
})
