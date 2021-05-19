package controller

import domain.Car
import view.View
import view.ViewValidator
import java.util.*
import kotlin.collections.ArrayList

class GameController(val view: View) {
    fun gameStart() {
        val validator = ViewValidator()
        try {
            val numCar = validator.validNumCar(view.inputNumCar())
            val numMatch = validator.validNumCar(view.inputNumMatch())
            val cars = ArrayList<Car>();
            for (i in 0 until numCar) {
                cars.add(Car(Integer.toString(i), 0))
            }
            val random = Random();
            for (i in 0 until numMatch) {
                for (car in cars) {
                    val randomNumber = random.nextInt(10)
                    if (randomNumber > 4) {
                        car.move();
                    }
                }

                view.printCarScore(cars)
            }

        } catch (e: IllegalArgumentException) {
            view.printInvalidGameInfo();
            gameStart()
        }


    }

}