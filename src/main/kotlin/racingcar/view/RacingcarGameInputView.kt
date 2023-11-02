package racingcar.view

import racingcar.model.RacingcarGameInput

object RacingcarGameInputView {
    fun getInput(): RacingcarGameInput {
        val carNamesString = getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = validateCarNamesString(carNamesString)

        val roundNumber = getInput("시도할 횟수는 몇 회인가요?")?.toIntOrNull()

        require(roundNumber != null && roundNumber > 0) {
            "시도 횟수는 자연수만 가능합니다."
        }

        return RacingcarGameInput(
            carNames = carNames,
            roundNumber = roundNumber
        )
    }

    private fun getInput(message: String): String? {
        println(message)

        return readlnOrNull()
    }

    private fun validateCarNamesString(carNamesString: String?): List<String> {
        require(carNamesString != null) {
            "자동차 이름은 null이거나 공백일 수 없습니다."
        }

        return carNamesString
            .split(",")
            .map { it.trim() }
            .map { validateCarName(it) }
    }

    private fun validateCarName(carName: String): String {
        require(carName.isNotBlank() && carName.length <= 5) {
            "자동차 이름은 공백이거나 5자를 초과할 수 없습니다."
        }

        return carName
    }
}
