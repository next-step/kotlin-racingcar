package game.manager

import game.car.Car
import game.randomnumbergenerator.RandomNumberGenerator
import game.randomnumbergenerator.RealRandomNumberGenerator
import game.view.GameView

val MOVE_THRESHOLD = 4


class GameManager(
    val cars: List<Car>,
    val randomNumberGenerator: RandomNumberGenerator = RealRandomNumberGenerator(),
    val gameView: GameView
) {
    fun tryMove(car: Car) {
        val randomNumber = randomNumberGenerator.generate()

        if (randomNumber >= MOVE_THRESHOLD) {
            car.move()
        }
    }

    fun playRound() {
        cars.forEach { car -> tryMove(car) }
    }

    fun playRounds(round: Int) {
        repeat(round) {
            playRound()
            println(gameView.showResult(getCarsPosition()))
        }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map { car -> car.position }
    }
}
