package racingCar.ui

import racingCar.entity.Car

class ResultView {
    fun printAllCarMoves(carList: List<Car>) {
        // for문 대신 forEach를 사용해 함수형 언어의 특징 살려 코딩
        carList.forEach { printCarMoves(it) }
        println()
    }

    fun printCarMoves(car: Car) {
        println("-".repeat(car.moves))
    }
}