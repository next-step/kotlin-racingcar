package racingcar.view

import racingcar.component.RacingcarGameInputValidator
import racingcar.model.RacingcarGameInput

class RacingcarGameInputView(
    private val racingcarGameInputValidator: RacingcarGameInputValidator = RacingcarGameInputValidator()
) {
    fun getInput(): RacingcarGameInput {
        val carNames = getCarNames()
        val rounds = getRounds()

        return RacingcarGameInput(
            carNames = carNames,
            rounds = rounds
        )
    }

    private fun getCarNames(): List<String> {
        val carNamesString = getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        return racingcarGameInputValidator.validateCarNamesString(carNamesString)
            .split(",")
            .map { it.trim() }
            .map { racingcarGameInputValidator.validateCarName(it) }
    }

    private fun getRounds(): Int {
        val roundsString = getInput("시도할 횟수는 몇 회인가요?")
        return racingcarGameInputValidator
            .validateRoundNumberString(roundsString)
            .toInt()
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }
}
