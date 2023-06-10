package racingcar.io

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Input
import racingcar.racing.Racing

class ResultView {

    fun printGame(input: Input) {
        println("실행 결과")

        val racing = Racing(input, printResult = ::printRound)
        racing.start()
    }

    private fun printRound(cars: Cars) {
        for (car in cars) {
            printRow(car)
        }
        println()
    }

    private fun printRow(car: Car) {
        println("-".repeat(car.getPosition()))
    }
}
