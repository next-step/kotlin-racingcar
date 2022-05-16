package racingcar.view

import racingcar.car.Car
import racingcar.race.Race

class ResultView(private val race: Race) {
    fun show() {
        println("\n실행 결과")
        repeat(race.moveCount) {
            val step = it + 1
            println("step - $step")
            showPositions(step)
        }
    }

    private fun showPositions(step: Int) = race.cars.forEach { car: Car -> showPosition(car.positionBy(step)) }

    private fun showPosition(position: Int) = println("|" + List(position) { "-" }.joinToString(""))
}
