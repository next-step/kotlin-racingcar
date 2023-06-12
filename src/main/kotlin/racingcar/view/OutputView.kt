package racingcar.view

import racingcar.domain.Car

class OutputView : OutputViewProtocol {

    // fun printRound(cars: ArrayList<Car>) {
    //     for (car in cars) {
    //         car.printLocation()
    //     }
    //     println()
    // }

    override fun printValue(value: Int) {
        for (i in 0 until value) {
            print("-")
        }
        println()
    }
}