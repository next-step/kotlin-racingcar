package racing.view

import racing.dto.Car

object CarRacingResultView {
    fun printCarRacingResult(cars: List<Car>, moveCount: Int) {
        // turnOfPosition의 0번 index는 기본으로 1이 셋팅되어있기때문에
        // 범위를 0 <= turn <= moveCount 로 설정
        for (turn in 0..moveCount) {
            printMovingDistanceByTurn(cars = cars, positionOf = { car -> car.turnOfPosition[turn] })
        }
    }

    private fun printMovingDistanceByTurn(cars: List<Car>, positionOf: (Car) -> Int) {
        cars.forEach { car ->
            printCurrentCarMovingDistance(carName = car.name, carPosition = positionOf(car))
        }
        println()
    }

    private fun printCurrentCarMovingDistance(carName: String, carPosition: Int) {
        println("$carName : ${"-".repeat(carPosition)}")
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.map { it.name }
        println("${winnerNames.joinToString()}가 최종 우승했습니다.")
    }
}
