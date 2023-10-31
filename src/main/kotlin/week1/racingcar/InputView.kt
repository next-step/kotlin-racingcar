package week1.racingcar

class InputView {
    fun startInput(): InputResult {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readlnOrNull()?.split(',')?.map { it }
        requireNotNull(carNames) {
            "자동차 이름은 null을 허용하지 않습니다."
        }

        println("시도할 횟수는 몇 회인가요?")
        val timesToRunGame = readlnOrNull()?.toInt()
        requireNotNull(timesToRunGame) {
            "시도할 횟수는 null을 허용하지 않습니다."
        }

        return InputResult(carNames, timesToRunGame)
    }
}