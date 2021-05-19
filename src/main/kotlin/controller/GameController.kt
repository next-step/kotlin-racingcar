package controller

import domain.Car
import domain.Cars
import view.View
import view.ViewValidator
import java.util.*
import kotlin.collections.ArrayList

class GameController(val view: View) {
    fun gameStart() {
        val validator = ViewValidator()
        try {
            val carNames = validator.validCarNames(view.inputNumCar())
            val numMatch = validator.validNumMatch(view.inputNumMatch())
            val cars = createCars(carNames)

            println("실행 결과")
            for (i in 0 until numMatch) {
                moveCars(cars);
                view.printCarScore(cars, numMatch)
            }
            view.printWinner(Winner(cars).findWinnerNames())

        } catch (e: IllegalArgumentException) {
            view.printInvalidGameInfo();
            gameStart()
        }


    }

    private fun moveCars(cars: Cars) {
        val random = Random();
        for (car in cars.cars) {
            val randomNumber = random.nextInt(10)
            if (randomNumber > 4) {
                car.move();
            }
        }
    }

    private fun createCars(carNames: String): Cars {
        val cars = ArrayList<Car>();
        for (carName in carNames.split(",")) {
            cars.add(Car(carName, 0))
        }
        return Cars(cars)
    }
}