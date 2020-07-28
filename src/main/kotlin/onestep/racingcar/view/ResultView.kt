package onestep.racingcar.view

import onestep.racingcar.model.Car

class ResultView {
    companion object {
        private const val INPUT_NUMBER_OF_CAR = "##레이싱##"
        private const val CAR_POSITION = "-"
        private const val WINNER_OF_RACING = "--WinneR--"
    }

    fun showResult(list: List<Car>) {
        println(INPUT_NUMBER_OF_CAR)
        list.forEach { car ->
            println("${car.name} :${makePositionString(car.position)}")
        }
    }

    fun showWinner(list: List<Car>) {
        println(WINNER_OF_RACING)
        println(list.joinToString { it.name })
    }

    private fun makePositionString(position: Int) = (1..position).joinToString("") { CAR_POSITION }
}
