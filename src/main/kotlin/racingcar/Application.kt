package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Name
import racingcar.domain.RandomNumberGenerator
import racingcar.view.inputCarNameValues
import racingcar.view.inputCountOfRace
import racingcar.view.printCars
import racingcar.view.printResultMessage

fun main() {
    val names = inputCarNameValues().map { Name(it) }

    var cars = Cars(names.map { Car(it) })
    val carsRange = (cars.elements.indices)

    val round = inputCountOfRace()

    printResultMessage()
    for (i in (0..round)) {
        val numbers = carsRange.map { RandomNumberGenerator().generate() }
        val movedCar = cars.move(numbers)
        printCars(movedCar)
        cars = movedCar
    }
}
