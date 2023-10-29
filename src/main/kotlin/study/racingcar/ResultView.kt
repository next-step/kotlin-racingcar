package study.racingcar

class ResultView(private val outputReceiver: OutputReceiver) {

    fun startDisplayResult() {
        outputReceiver.receive("실행 결과")
    }

    fun displayRound(cars: Cars) {
        val result = cars.displayPositions().joinToString("\n") + "\n"
        outputReceiver.receive(result)
    }
}
