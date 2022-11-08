package study.step4.view

import study.step4.model.Car

object ResultView {

    fun resultRacingCar(champions: List<Car>, cars: List<Car>, racingTimes: Int) {
        println("실행 결과")
        (0 until racingTimes).forEach { times ->
            printCarHistory(cars, times)
        }
        printChampion(champions)
    }

    private fun printChampion(champions: List<Car>) {
        val championNames = champions.map { it.name }.joinToString(", ")
        println("${championNames}가 최종 우승했습니다.")
    }

    private fun printCarHistory(cars: List<Car>, times: Int) {
        cars.forEach {
            val i = it.getHistory()[times]
            println("${it.name} : " + "-".repeat(i))
        }
        println()
    }
}
