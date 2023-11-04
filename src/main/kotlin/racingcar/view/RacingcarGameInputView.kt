package racingcar.view

import racingcar.component.RacingcarGameInputValidator
import racingcar.model.RacingcarGameInput

object RacingcarGameInputView {
    fun getInput(): RacingcarGameInput {
        val carNames = getCarNames()
        val roundNumber = getRoundNumber()

        return RacingcarGameInput(
            carNames = carNames,
            roundNumber = roundNumber
        )
    }

    private fun getCarNames(): List<String> {
        val carNamesString = getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        return RacingcarGameInputValidator.validateCarNamesString(carNamesString)
            .split(",")
            .map { it.trim() }
            .map { RacingcarGameInputValidator.validateCarName(it) }
    }

    private fun getRoundNumber(): Int {
        val roundNumberString = getInput("시도할 횟수는 몇 회인가요?")
        return RacingcarGameInputValidator
            .validateRoundNumberString(roundNumberString)
            .toInt()
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }
}
