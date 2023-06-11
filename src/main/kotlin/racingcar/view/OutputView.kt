package racingcar.view

import racingcar.domain.Car

class OutputView {

    fun printRound(cars: ArrayList<Car>) {
        for (car in cars) {
            car.printLocation()
        }
    }

}