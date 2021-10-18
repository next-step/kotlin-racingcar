package racingcar.view

import racingcar.domain.Cars
import racingcar.domain.Record

class OutputView(private val record: Record, private val winners: Cars?) {

    fun showResult() {
        println(EXECUTE_RESULT)
        showRecords()
        showWinner()
    }

    private fun showRecords() {
        for (count in FIRST_GAME..record.getSize()) {
            val recordedCars: Cars? = record[count]
            recordedCars?.let { showCarPositions(it) }
            println()
        }
    }

    private fun showCarPositions(cars: Cars) {
        for (car in cars.cars) {
            val carName = car.name
            val position = showGraph(car.getPosition())
            println("$carName : $position")
        }
    }

    private fun showGraph(position: Int): String {
        return buildString {
            for (i in 0..position) {
                append(DASH)
            }
        }
    }

    private fun showWinner() {
        if (this.winners?.cars == null) {
            return
        }
        val result = buildString {
            for (car in winners.cars) {
                append("${car.name}$COMMA")
            }
        }

        val winners = result.substring(0, result.length - MARGIN)
        println(winners + WINNER_MESSAGE)
    }

    companion object {
        private const val EXECUTE_RESULT = "실행 결과"
        private const val WINNER_MESSAGE = "가 최종 우승했습니다."
        private const val COMMA = ","
        private const val DASH = "-"
        private const val FIRST_GAME = 1
        private const val MARGIN = 1
    }
}
