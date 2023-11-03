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

    private fun displayPosition(car: Car): String = "${car.name} : " + "-".repeat(car.position)

    fun displayWinners(winners: Cars) {
        val winnerNames = winners.list.joinToString(", ") { it.name }
        outputReceiver.receive("$winnerNames 가 최종 우승했습니다.")
    }
}
