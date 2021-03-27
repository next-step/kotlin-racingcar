package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RandomNumberGenerator
import racingcar.domain.Round
import racingcar.view.inputCountOfCar
import racingcar.view.inputCountOfRace
import racingcar.view.printCars
import racingcar.view.printResultMessage

fun main() {
    val carRange = (0 until inputCountOfCar())

    var cars = Cars(carRange.map { Car() })

    val round = inputCountOfRace()

    printResultMessage()
    for (i in (0..round)) {
        val numbers = carsRange.map { RandomNumberGenerator().generate() }
        val movedCar = cars.move(numbers)
        printCars(movedCar)
        cars = movedCar
    }
}
