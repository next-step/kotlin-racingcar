package racingcar

import racingcar.view.InputView

fun main() {
    val inputView = InputView()

    val nameOfCars = inputView.getNameOfCars()
    val tryCount = inputView.getTryCount()

    val cars = Cars(nameOfCars.map { Car(name = it) })
    cars.game(tryCount)
}
