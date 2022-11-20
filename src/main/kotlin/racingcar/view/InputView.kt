package racingcar.view

import racingcar.domain.Car

object InputView {
    fun readCars(): List<Car> {
        println("자동차 대수는 몇 대인가요?")

        val list = mutableListOf<Car>()
        repeat(readln().toInt()) {
            list.add(Car())
        }

        return list
    }

    fun readRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
