package study.racingcar.domain

import study.racingcar.view.view

class Racing(numOfCar: Int, moving: Moving) {

    private val cars = (1..numOfCar).map { Car(moving) }

    fun race() {
        cars.forEach {
            it.move()
            it.view.print()
        }
    }
}
