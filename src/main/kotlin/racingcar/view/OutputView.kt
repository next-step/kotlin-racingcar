package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printResult() {
        println("실행 결과")
    }

    fun printCarPosition(car: Car) {
        print("${car.getCarNameString()} : ")
        println("-".repeat(car.position))
    }
}
