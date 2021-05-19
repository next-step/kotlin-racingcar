package controller

import domain.Car
import view.View
import view.ViewValidator

class GameController(val view: View) {
    fun gameStart() {
        val validator = ViewValidator()
        try {
            val carNames = validator.validCarNames(view.inputNumCar())
            val numMatch = validator.validNumMatch(view.inputNumMatch())
            val cars = createCars(carNames)
            view.printCarScore(cars, numMatch)
        } catch (e: IllegalArgumentException) {
            view.printInvalidGameInfo();
            gameStart()
        }


    }

    fun createCars(carNames: String): ArrayList<Car> {
        val cars = ArrayList<Car>();
        for (carName in carNames.split(",")) {
            cars.add(Car(carName, 0))
        }
        return cars
    }
}