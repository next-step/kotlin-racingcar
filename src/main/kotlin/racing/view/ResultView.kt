package racing.view

import racing.domain.car.Car
import racing.domain.common.CarRaceProperty

class ResultView(private val carRaceProperty: CarRaceProperty) {

    fun printCarPositionByRound() {
        repeat(carRaceProperty.roundSize) { round ->
            println("-- [${round + 1}]회차 결과 ------")

            carRaceProperty.cars
                .map { car ->
                    printPositionByRound(car, round)
                }

            println("--------------------")
        }
    }

    private fun printPositionByRound(car: Car, round: Int) {
        println("${car.carName} : ${getForwardMoveMark(getPositionByRound(car, round))}")
    }

    private fun getPositionByRound(car: Car, round: Int): Int {
        return car.positionByRound[round] ?: throw IllegalArgumentException("${round}라운드의 ${car.carName}의 위치를 찾는데 문제가 발생했습니다.")
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
