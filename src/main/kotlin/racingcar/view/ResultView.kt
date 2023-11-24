package racingcar.view

import racingcar.domain.Car

class ResultView {
    companion object {
        fun displayRacingStartMessage() {
            println("실행 결과")
        }

        fun displayCarLocation(car: Car) {
            println("${car.name} : " + "-".repeat(car.getDistance))
        }

        fun displayWinner(cars: List<Car>) {
            val maxDistance = findMaxDistance(cars)
            val winners = cars.filter { it.getDistance == maxDistance }
            println("최종 우승자는 ${winners.joinToString { it.name }} 입니다.")
        }

        private fun findMaxDistance(cars: List<Car>): Int {
            return cars.maxByOrNull { it.getDistance }?.getDistance
                ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
        }
    }
}
