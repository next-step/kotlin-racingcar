package racing.view

import racing.car.Car
import racing.common.CarRaceProperty

class ResultView(private val carRaceProperty: CarRaceProperty) {

    fun printResultByRound(round: Int) {
        println("-- [$round]회차 결과 ------")
        carRaceProperty.cars.map { printResultByCar(it) }
        println("--------------------")
    }

    private fun printResultByCar(car: Car) {
        println("${car.getCarName()} : ${getForwardMoveMark(car.getMoveCount())}")
    }

    private fun getForwardMoveMark(move: Int): String {
        var forwardMark = ""
        repeat(move) {
            forwardMark += MARK_FORWARD_MOVE
        }
        return forwardMark
    }

    fun printWinner() {
        println("${getWinnerCarNames()}가 최종 우승했습니다.")
    }

    private fun getWinnerCarNames(): String {
        return carRaceProperty.cars
            .filter { it.getMoveCount() == getWinnerCount() }
            .joinToString(",") { it.getCarName() }
    }

    private fun getWinnerCount(): Int {
        return carRaceProperty.cars
            .maxByOrNull { it.getMoveCount() }!!
            .getMoveCount()
    }

    companion object {
        private const val MARK_FORWARD_MOVE = "> "
    }
}
