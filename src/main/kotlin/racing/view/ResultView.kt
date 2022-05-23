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
        println("${car.carName} : ${getForwardMoveMark(car.moveCount)}")
    }

    private fun getForwardMoveMark(move: Int): String {
        return MARK_FORWARD_MOVE.repeat(move)
    }

    fun printWinner(winnerCarNames: String) {
        println("${winnerCarNames}가 최종 우승했습니다.")
    }

    companion object {
        private const val MARK_FORWARD_MOVE = "> "
    }
}
