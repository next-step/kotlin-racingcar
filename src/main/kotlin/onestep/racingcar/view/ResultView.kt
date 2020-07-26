package onestep.racingcar.view

import onestep.racingcar.model.Car

class ResultView {
    companion object {
        private const val INPUT_NUMBER_OF_CAR = "##레이싱##"
        private const val CAR_POSITION = "-"
    }

    fun showResult(list: List<Car>) {
        println(INPUT_NUMBER_OF_CAR)
        list.forEach {
            println(makePositionString(it.position))
        }
    }

    private fun makePositionString(position: Int) = (1..position).joinToString("") { CAR_POSITION }
}
