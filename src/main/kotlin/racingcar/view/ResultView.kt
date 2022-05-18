package racingcar.view

import racingcar.race.Race

class ResultView(race: Race) {
    private val cars = race.cars
    private val steps = List(race.railSize) { it + 1 }

    fun showResult() {
        println("\n실행 결과")
        steps.forEach { step: Int ->
            showPositionsBy(step)
            println()
        }
    }

    private fun showPositionsBy(step: Int) = cars.forEach { showPositionBy(it.positionBy(step)) }

    companion object {
        private fun showPositionBy(position: Int) = println(stringBy(position))

        private fun stringBy(position: Int): String = "-".repeat(position)
    }
}
