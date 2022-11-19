package car_race.view

import car_race.logic.car.Cars

object ResultView {

    fun resultViewStart() = println("실행 결과")

    fun printEachRound(cars: Cars) {
        cars.cars.forEach { car ->
            print("${car.carName.name} : ")
            println("-".repeat(car.carPosition.position + 1))
        }
        println()
    }

    fun printWinners(cars: Cars) {
        val winnerNames = cars.getWinners().map { car -> car.carName.name }
        println("${winnerNames.joinToString()}가 최종 우승했습니다.")
    }
}
