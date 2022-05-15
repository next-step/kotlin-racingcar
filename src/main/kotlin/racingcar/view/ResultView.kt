package racingcar.view

import racingcar.domain.Car

class ResultView {
    fun printRacingResult() {
        println("실행 결과")
    }

    fun printCurrentRace(cars: List<Car>) {
        for (car in cars) {
            println(mapForDisplay(car.distance))
        }
        println()
    }

    private fun mapForDisplay(distance: Int): String {
        val stringBuilder = StringBuilder()

        for (i in 1..distance) {
            stringBuilder.append(DISTANCE_VIEW)
        }

        return stringBuilder.toString()
    }

    companion object {
        private const val DISTANCE_VIEW = "-"
    }
}
