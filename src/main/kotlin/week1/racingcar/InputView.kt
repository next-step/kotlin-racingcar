package week1.racingcar

class InputView {
    fun startInput(): InputResult {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readlnOrNull()?.toInt()
        println("시도할 횟수는 몇 회인가요?")
        val timesToRunGame = readlnOrNull()?.toInt()

        require(carNumber != null)
        require(timesToRunGame != null)

        return InputResult(carNumber, timesToRunGame)
    }
}