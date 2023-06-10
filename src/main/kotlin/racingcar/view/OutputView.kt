package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

class OutputView {
    fun printResult() {
        println("실행 결과")
    }

    fun printCarPosition(car: Car) {
        print("${car.getCarNameString()} : ")
        println("-".repeat(car.position))
    }

    fun printWinners(cars: Cars) {
        print("${cars.getWinners()}가 최종 우승했습니다.")
    }
}
