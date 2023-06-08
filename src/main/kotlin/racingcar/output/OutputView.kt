package racingcar.output

import racingcar.car.Car

class OutputView {
    companion object {
        private val CAR: String = "-"
    }

    fun printCars(cars: List<Car>) {
        cars
            .asSequence()
            .map { CAR.repeat(it.distance) }
            .forEach { println(it) }
    }

    fun announceRoundStart(round: Int) {
        println("$round 라운드 시작")
    }
}
