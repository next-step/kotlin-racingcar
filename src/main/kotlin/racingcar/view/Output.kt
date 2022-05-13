package racingcar.view

import racingcar.model.CarName

import racingcar.model.Cars

class Output {

    fun showStartMessage() {
        println("----------------------------------")
        println("실행결과")
    }

    fun showResultPosition(cars: Cars) {
        cars.forEach {
            showName(it.name)
            showGauge(it.position)
        }
        println()
    }

    private fun showName(name: CarName) {
        print("$name : ")
    }

    private fun showGauge(position: Int) {
        repeat(position) {
            print("-")
        }
        println()
    }
}
