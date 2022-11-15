package car_race.view

import car_race.logic.car.CarName
import car_race.logic.car.CarPosition
import car_race.logic.car.Cars

object ResultView {

    fun resultViewStart() = println("실행 결과")

    fun printEachRound(cars: Cars) {
        cars.getNameAndPositionList().forEach { (carName, carPosition) ->
            printNameAndPosition(carName, carPosition)
        }
        println()
    }

    private fun printNameAndPosition(carName: CarName, carPosition: CarPosition) {
        print("${carName.getName()} : ")
        println("-".repeat(carPosition.getValue() + 1))
    }

    fun printWinners(cars: Cars) {
        val winnerNames = cars.getWinners().map { car -> car.getName() }
        println("${winnerNames.joinToString()}가 최종 우승했습니다.")
    }
}
