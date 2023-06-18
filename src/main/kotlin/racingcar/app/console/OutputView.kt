package racingcar.app.console

import racingcar.domain.Car
import racingcar.domain.RacingResult

class OutputView {

    fun writeMessage(message: String) {
        println(message)
    }

    fun writeCars(racingResult: RacingResult) {
        racingResult.cars.forEach { writeCar(it) }
        writeLineBreak()
        if (racingResult.end)
            writeWinners(racingResult.winners())
    }

    private fun writeCar(car: Car) {
        println("${car.name} : ${MOVE_SIGN.repeat(car.position)}")
    }

    private fun writeWinners(winners: List<Car>) {
        val names = winners.joinToString(", ") { it.name }
        println("${names}가 최종 우승했습니다.")
    }

    private fun writeLineBreak() {
        println()
    }

    companion object {
        const val MOVE_SIGN = "-"
    }
}
