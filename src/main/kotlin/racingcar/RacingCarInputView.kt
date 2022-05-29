package racingcar

object RacingCarInputView {
    fun input(): RacingCarRequest {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ")
        val carNamesInput = readLine()
        println("경주는 몇 라운드를 진행할 것인가요? ")
        val roundsInput = readLine()
        return RacingCarRequest.of(carNamesInput = carNamesInput, roundsInput = roundsInput)
    }
}

class RacingCarRequest(val carNames: CarNames, val rounds: Rounds) {
    companion object {
        fun of(carNamesInput: String?, roundsInput: String?): RacingCarRequest {
            validateCarNames(carNamesInput = carNamesInput)
            validateRounds(roundsInput = roundsInput)
            val carNames: List<String> = carNamesInput!!.split(NAMES_DELIMITER).map(String::trim)
            return RacingCarRequest(CarNames.of(carNames), Rounds(roundsInput!!.toInt()))
        }

        private fun validateCarNames(carNamesInput: String?) {
            require(!carNamesInput.isNullOrBlank()) { "경주할 자동차 이름의 입력값은 빈 값이거나, 공백일 수 없습니다." }
        }

        private fun validateRounds(roundsInput: String?) {
            require(!roundsInput.isNullOrBlank()) { "라운드 입력값은 빈 값이거나, 공백일 수 없습니다." }
            roundsInput.toIntOrNull()
                ?: throw IllegalArgumentException("라운드 입력값은 정수여야 합니다.")
        }

        private const val NAMES_DELIMITER = ","
    }
}
