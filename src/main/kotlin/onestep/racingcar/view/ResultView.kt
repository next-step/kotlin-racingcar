package onestep.racingcar.view

import onestep.racingcar.domain.Cars

class ResultView {
    fun showResult(cars: Cars) {
        println(INPUT_NUMBER_OF_CAR)
        println(cars)
    }

    fun showWinner(cars: Cars) {
        println(WINNER_OF_RACING)
        println(cars.toCarNameList().joinToString(","))
    }

    companion object {
        private const val INPUT_NUMBER_OF_CAR = "##레이싱##"
        private const val WINNER_OF_RACING = "--WinneR--"
    }
}
