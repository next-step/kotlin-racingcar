package study.step3

import study.step3.io.Input
import study.step3.io.Output
import study.step3.io.View

class CarRacingGameApplication(
    private val view: View,
) {
    private val cars = mutableListOf<Car>()
    private val scoreboard = Scoreboard()

    fun run() {
        view.numberOfCarView { numberOfCar ->
            cars.addAll(createCars(numberOfCar))
        }
        view.numberOfRoundView { numberOfRound ->
            startGame(cars, scoreboard, numberOfRound)
        }
        view.resultView(scoreboard)
    }

    private fun startGame(cars: MutableList<Car>, scoreboard: Scoreboard, numberOfRound: Int) {
        repeat(numberOfRound) {
            val scores = cars.onEach { car ->
                car.move()
            }.map {
                Score(it.mileage)
            }
            scoreboard.addScores(scores)
        }
    }

    private fun createCars(numberOfCar: Int): List<Car> {
        return List(numberOfCar) {
            Car()
        }
    }
}

fun main() {
    val input = Input()
    val output = Output()
    val view = View(input, output)
    val application = CarRacingGameApplication(view)
    application.run()
}
