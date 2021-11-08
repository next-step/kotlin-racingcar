package racingcar

import racingcar.domain.RaceGame

class Result {

    fun displayCarsResult(raceGame: RaceGame) {
        raceGame.cars
            .forEach {
                car -> draw(car.distance)
            }
        println()
    }

    private fun draw(barCount: Int) {
        for(i in 1 .. barCount) {
            print(MINUS_ICON)
        }
        println()
    }

    private companion object {
        const val MINUS_ICON = "-"
    }
}