package racingcar.output

import racingcar.car.Car

class OutputView {
    fun announceResult() = println("실행 결과")

    fun printCars(cars: List<Car>) {
        cars
            .map { CAR.repeat(it.distance) }
            .forEach { println(it) }
    }

    fun announceRoundStart(round: Int) {
        println("$round 라운드 시작")
    }

    companion object {
        private const val CAR: String = "-"
    }
}
