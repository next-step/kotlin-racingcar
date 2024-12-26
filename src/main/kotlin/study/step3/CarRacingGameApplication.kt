package study.step3

import study.step3.domain.Car
import study.step3.domain.Engine
import study.step3.domain.Scoreboard
import study.step3.view.Input
import study.step3.view.Output
import study.step3.view.View

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
                Scoreboard.Item(
                    title = car.name,
                    score = car.mileage.value
                )
            }
            scoreboard.add(scores)
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
