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
        (FIRST_GAME..record.getSize()).forEach { it ->
            val recordedCars: Cars? = record[it]
            recordedCars?.let { showCarPositions(it) }
            println()
        }
    }

    private fun showCarPositions(recordedCars: Cars) {
        recordedCars.cars.forEach {
            val carName = it.name
            val position = showGraph(it.getPosition())
            println("$carName : $position")
        }
    }

    private fun showGraph(position: Int): String {
        return DASH.repeat(position)
    }

    private fun showWinner() {
        if (this.winners?.cars == null) {
            return
        }
        val winnerNames = winners.cars
            .joinToString(separator = COMMA) { it.name.toString() }
        println(winnerNames + WINNER_MESSAGE)
    }

    companion object {
        private const val EXECUTE_RESULT = "실행 결과"
        private const val WINNER_MESSAGE = "가 최종 우승했습니다."
        private const val COMMA = ","
        private const val DASH = "-"
        private const val FIRST_GAME = 1
    }
}
