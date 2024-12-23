package study.step3

import study.step3.entity.Car
import study.step3.entity.Engine
import study.step3.entity.Score
import study.step3.entity.Scoreboard
import study.step3.io.Input
import study.step3.io.Output
import study.step3.io.View

class CarRacingGameApplication(
    private val view: View,
) {
    private val cars = mutableListOf<Car>()
    private val scoreboard = Scoreboard()

    fun run() {
        view.numberOfCarView { carNames ->
            cars.addAll(createCars(carNames))
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
            }.map { car ->
                Score(
                    carName = car.name,
                    score = car.mileage
                )
            }
            scoreboard.addScores(scores)
        }
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(name = it, engine = Engine()) }
    }
}

fun main() {
    val input = Input()
    val output = Output()
    val view = View(input, output)
    val application = CarRacingGameApplication(view)
    application.run()
}
