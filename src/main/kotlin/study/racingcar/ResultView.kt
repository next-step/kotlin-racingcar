package study.racingcar

class ResultView(private val outputReceiver: OutputReceiver) {

    fun startDisplayResult() {
        outputReceiver.receive("실행 결과")
    }

    fun displayRound(cars: Cars) {
        val result = displayPositions(cars).joinToString("\n") + "\n"
        outputReceiver.receive(result)
    }

    private fun displayPositions(cars: Cars): List<String> {
        return cars.list.map { displayPosition(it) }
    }

    private fun displayPosition(car: Car): String = "-".repeat(car.position)
}
