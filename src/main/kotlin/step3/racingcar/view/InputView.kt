package step3.racingcar.view

import step3.racingcar.extension.isNotDigit

class InputView {
    companion object {
        private const val CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_COUNT_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val COMMA = ","
        private const val MINIMUM_JOIN_CAR_COUNT = 2
        private const val MAXIMUM_CAR_NAME_LENGTH = 5

        private const val MINIMUM_JOIN_CAR_COUNT_ERROR_MESSAGE = "잘못 입력하셧습니다. [%s], 최소 `$MINIMUM_JOIN_CAR_COUNT`대 이상의 차량의 이름을 [,]를 이용해서 입력하세요."
        private const val NOT_VALID_CAR_NAME_ERROR_MESSAGE = "올바르지 않은 차량 이름입니다. [%s], 빈값, 공백을 제외한 차량 이름을 입력하세요."
        private const val INVALID_TOTAL_ROUND_ERROR_MESSAGE = "잘못 입력하셨습니다. [%s], 숫자만 입력하세요."
        private const val OVER_THAN_MAXIMUM_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 `$MAXIMUM_CAR_NAME_LENGTH`자를 초과할 수 없습니다. : [%s]"

        fun inputJoinerCarsGuideMessagePrinter(): List<String> {
            return inputCarNames()
        }

        private fun inputCarNames(): List<String> {
            var carNames: String
            var separatedCarNames: List<String>
            do {
                println(CAR_NAMES_INPUT_GUIDE_MESSAGE)
                carNames = readLine()!!
                separatedCarNames = carNames.split(COMMA)
            } while (isNotValidCarNames(separatedCarNames))
            return separatedCarNames
        }

        private fun isNotValidCarNames(separatedCarNames: List<String>): Boolean =
            isNotValidCarCount(separatedCarNames) || isNotValidCarNamesLength(separatedCarNames)

        private fun isNotValidCarCount(separatedCarNames: List<String>): Boolean {
            if (separatedCarNames.size < MINIMUM_JOIN_CAR_COUNT) {
                println(MINIMUM_JOIN_CAR_COUNT_ERROR_MESSAGE.format(separatedCarNames))
                return true
            }
            return false
        }

        private fun isNotValidCarNamesLength(separatedCarNames: List<String>): Boolean {
            val validateResult = mutableSetOf<Boolean>()
            separatedCarNames.forEach {
                validateResult.add(isNotValidLength(it))
                validateResult.add(isNotValidName(it))
            }
            return validateResult.find { it } ?: false
        }

        private fun isNotValidName(carName: String): Boolean {
            if (carName.isBlank()) {
                println(NOT_VALID_CAR_NAME_ERROR_MESSAGE.format(carName))
                return true
            }
            return false
        }

        private fun isNotValidLength(carName: String): Boolean {
            if (carName.length >= MAXIMUM_CAR_NAME_LENGTH) {
                println(OVER_THAN_MAXIMUM_CAR_NAME_LENGTH_ERROR_MESSAGE.format(carName))
                return true
            }
            return false
        }

        fun inputRoundCountGuideMessagePrinter(): Int {
            return inputRoundCount()
        }

        private fun inputRoundCount(): Int {
            var input: String
            do {
                println(ROUND_COUNT_INPUT_GUIDE_MESSAGE)
                input = readLine()!!
            } while (isNotValidInput(input))
            return input.toInt()
        }

        private fun isNotValidInput(inputValue: String): Boolean {
            val condition = inputValue.isNotDigit()
            if (condition) {
                println(INVALID_TOTAL_ROUND_ERROR_MESSAGE.format(inputValue))
            }
            return condition
        }
    }
}
