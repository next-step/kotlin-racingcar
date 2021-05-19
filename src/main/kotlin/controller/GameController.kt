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
        val carNames = validator.validCarNames(view.inputNumCar())
        val numMatch = validator.validNumMatch(view.inputNumMatch())
        val cars = createCars(carNames)

        println("실행 결과")
        for (i in 0 until numMatch) {
            moveCars(cars);
            view.printCarScore(cars, numMatch)
        }
        view.printWinner(Winner(cars).findWinnerNames())


    }

    private fun moveCars(cars: Cars) {
        val random = Random();
        val expectedMoveCars = cars.cars.filter { random.nextInt(10) > 4 }
        expectedMoveCars.map { it.move() }
    }

    private fun createCars(carNames: String): Cars {
        val cars = ArrayList<Car>();
        for (carName in carNames.split(",")) {
            cars.add(Car(carName, 0))
        }
        return Cars(cars)
    }
}