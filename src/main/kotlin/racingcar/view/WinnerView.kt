package racingcar.view

import racingcar.model.Car

private const val STRING_JOINER = ", "

class WinnerView(private val winners: List<Car>) {
    fun printWinner() {
        val result = winners.joinToString(STRING_JOINER) { car -> car.name }
        println(">>>>> ${result}가 최종 우승했습니다. ")
    }
}
