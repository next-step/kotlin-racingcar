package racingcar.view

import racingcar.domain.Cars
import racingcar.domain.Record

class OutputView(private val record: Record) {

    fun showResult() {
        println(EXECUTE_RESULT)
        showRecords()
    }

    private fun showRecords() {
        for (count in FIRST_GAME..record.getSize()) {
            val recordedCars: Cars? = record.getRecord(count)
            recordedCars?.let { showCarPositions(it) }
            println()
        }
    }

    private fun showCarPositions(cars: Cars) {
        for (car in cars.cars) {
            val position = showGraph(car.getPosition())
            println(position)
        }
    }

    private fun showGraph(position: Int): String {
        val sb = StringBuilder()
        for (i in 0..position) {
            sb.append(DASH)
        }
        return sb.toString()
    }

    companion object {
        private const val EXECUTE_RESULT = "실행 결과"
        private const val DASH = "-"
        private const val FIRST_GAME = 1
    }
}
