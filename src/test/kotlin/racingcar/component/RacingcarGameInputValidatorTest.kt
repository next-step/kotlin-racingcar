package racingcar.component

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class RacingcarGameInputValidatorTest : FunSpec({
    context("자동차 이름 입력 테스트") {
        test("자동차 이름 문자열이 null인 경우") {
            shouldThrow<IllegalArgumentException> {
                val carNamesString = null

                RacingcarGameInputValidator.validateCarNamesString(carNamesString)
            }
        }

        test("자동차 이름이 공백인 경우") {
            shouldThrow<IllegalArgumentException> {
                val carName = ""

                RacingcarGameInputValidator.validateCarName(carName)
            }
        }

        test("자동차 이름이 5글자를 초과하는 경우") {
            shouldThrow<IllegalArgumentException> {
                val carName = "testNameLengthMoreThan5"

                RacingcarGameInputValidator.validateCarName(carName)
            }
        }
    }

    context("게임 횟수 입력 테스트") {
        test("게임 횟수 문자열이 null 인 경우") {
            shouldThrow<IllegalArgumentException> {
                val roundNumberString = null

                RacingcarGameInputValidator.validateRoundNumberString(roundNumberString)
            }
        }

        test("게임 횟수 문자열이 0인 경우") {
            shouldThrow<IllegalArgumentException> {
                val roundNumberString = "0"

                RacingcarGameInputValidator.validateRoundNumberString(roundNumberString)
            }
        }

        test("게임 횟수 문자열이 음수인 경우") {
            shouldThrow<IllegalArgumentException> {
                val roundNumberString = "-1"

                RacingcarGameInputValidator.validateRoundNumberString(roundNumberString)
            }
        }
    }
})
