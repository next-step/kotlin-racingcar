package racingcar.view

import racingcar.domain.car.Car

class ResultView {
    fun printRacingResult() {
        println("실행 결과")
    }

    fun printCurrentRace(cars: List<Car>) {
        cars.forEach {
            println("${it.getName()} : ${mapForDisplay(it.distance)}")
        }
        println()
    }

    private fun mapForDisplay(distance: Int): String {
        val stringBuilder = StringBuilder()
        repeat(times = distance) { stringBuilder.append(DISTANCE_VIEW) }
        return stringBuilder.toString()
    }

    companion object {
        private const val DISTANCE_VIEW = "-"
    }
}
