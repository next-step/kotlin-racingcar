package controller

import domain.Car
import view.View
import view.ViewValidator

class GameController(val view: View) {
    fun gameStart() {
        val validator = ViewValidator()
        try {
            val numCar = validator.validNumCar(view.inputNumCar())
            val numMatch = validator.validNumCar(view.inputNumMatch())
            val cars = createCars(numCar)

            view.printCarScore(cars, numMatch)


        } catch (e: IllegalArgumentException) {
            view.printInvalidGameInfo();
            gameStart()
        }


    }

    fun createCars(numCar: Int): ArrayList<Car> {
        val cars = ArrayList<Car>();
        for (i in 0 until numCar) {
            cars.add(Car(Integer.toString(i), 0))
        }
        return cars
    }
}