package week1.racingcar.view

object InputView {
    fun getValidateRaceInfo(): InputResult {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carListInput = readlnOrNull()
        println("시도할 횟수는 몇 회인가요?")
        val timesInput = readlnOrNull()

        val carNames = carListInput?.split(',')?.map { it }
        requireNotNull(carNames) {
            "자동차 이름은 null을 허용하지 않습니다."
        }

        val timesToRunGame = timesInput?.toInt()
        requireNotNull(timesToRunGame) {
            "시도할 횟수는 null을 허용하지 않습니다."
        }

        return InputResult(carNames, timesToRunGame)
    }
}
