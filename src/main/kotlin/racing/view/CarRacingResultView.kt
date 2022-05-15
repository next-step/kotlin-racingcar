package racing.view

import racing.dto.Car
import racing.dto.Winners

object CarRacingResultView {
    fun printCarRacingResult(cars: List<Car>, moveCount: Int) {
        // turnOfPosition의 0번 index는 기본으로 1이 셋팅되어있기때문에
        // 범위를 0 <= turn <= moveCount 로 설정
        for (turn in 0..moveCount) {
            printMovingDistanceByTurn(cars = cars, turn = turn)
        }
    }

    private fun printMovingDistanceByTurn(cars: List<Car>, turn: Int) {
        cars.forEach { car ->
            printCurrentCarMovingDistance(carName = car.name, carPosition = car.turnOfPosition[turn])
        }
        println()
    }

    private fun printCurrentCarMovingDistance(carName: String, carPosition: Int) {
        println("$carName : ${"-".repeat(carPosition)}")
    }

    fun printWinners(winners: Winners) {
        winners.winnerNames.dropLast(1).forEach { winnerName ->
            print("$winnerName, ")
        }
        println("${winners.winnerNames.last()}가 최종 우승했습니다.")
    }
}
