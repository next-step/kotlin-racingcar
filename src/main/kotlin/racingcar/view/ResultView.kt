package racingcar.view

import racingcar.domain.Car

object ResultView {
    // 시도회수를 받고 그 회수 만큼
    fun printResult(
        cars: List<Car>,
        movingCount: Int,
    ) {
        val convertedCarsCount = MutableList(cars.size) { "" }
        repeat(movingCount) {
            cars.forEachIndexed { carIndex, car ->
                if (car.movingDistance > it) {
                    convertedCarsCount[carIndex] += "-"
                }
                println("${car.carName} : ${convertedCarsCount[carIndex]}")
            }
            println()
        }
    }

    fun printWinner(findWinner: List<Car>) {
        println("${findWinner.joinToString(separator = ",") { it.carName }}가 최종 우승했습니다.")
    }
}
