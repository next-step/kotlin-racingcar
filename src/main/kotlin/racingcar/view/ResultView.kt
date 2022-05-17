package racingcar.view

import racingcar.race.Race

class ResultView(race: Race) {
    private val cars = race.cars
    private val steps = List(race.moveCount) { it + 1 }

    fun show() {
        println("\n실행 결과")
        steps.forEach(fun(step: Int) {
            showPositionsBy(step)
            println()
        })
    }

    private fun showPositionsBy(step: Int) = cars.forEach { showPositionBy(it.positionBy(step)) }

    companion object {
        private fun showPositionBy(position: Int) = println(stringBy(position))

        private fun stringBy(position: Int) = List(position) { "-" }.joinToString("")
    }
}
