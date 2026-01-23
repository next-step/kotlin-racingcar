package game.manager

import game.car.Car
import game.randomnumbergenerator.RandomNumberGenerator
import game.randomnumbergenerator.RealRandomNumberGenerator
import game.view.GameView

val MOVE_THRESHOLD = 4


class GameManager(
    val cars: List<Car>,
    val RandomNumberGenerator: RandomNumberGenerator = RealRandomNumberGenerator(),
    val GameView: GameView
) {
    fun tryMove(car: Car) {
        val randomNumber = RandomNumberGenerator.generate()

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
            GameView.showResult(getCarsPosition())
        }
    }

    fun getCarsPosition(): List<Int> {
        return cars.map { car -> car.position }
    }
}
