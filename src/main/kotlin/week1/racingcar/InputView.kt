package week1.racingcar

class InputView {
    fun startInput(): InputString {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carListInput = readlnOrNull()
        val timesInput = readlnOrNull()
        println("시도할 횟수는 몇 회인가요?")
        return InputString(carListInput, timesInput)
    }

    fun getValidateRaceInfo(inputString: InputString): InputResult {
        val carNames = inputString.cars?.split(',')?.map { it }
        requireNotNull(carNames) {
            "자동차 이름은 null을 허용하지 않습니다."
        }
        carNames.forEach {
            require(it.isNotBlank()) {
                "자동차 이름은 빈 칸을 허용하지 않습니다."
            }
            require(it.length <= 5) {
                "자동차 이름은 5자를 초과해선 안됩니다."
            }
        }

        val timesToRunGame = inputString.times?.toInt()
        requireNotNull(timesToRunGame) {
            "시도할 횟수는 null을 허용하지 않습니다."
        }

        return InputResult(carNames, timesToRunGame)
    }

    data class InputString(
        val cars: String?,
        val times: String?,
    )
}