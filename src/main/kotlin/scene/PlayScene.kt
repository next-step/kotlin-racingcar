package scene

import model.Car
import model.ScoreBoard

class PlayScene(
    private val scoreBoard: ScoreBoard,
) : Scene() {

    var currentRound = 0

    private var cars: List<Car>

    init {
        cars = (1..player).map { Car.spawnAt(0) }
    }

    override fun before() {
        currentRound++
    }

    override fun update() {
        cars = cars.map {
            it.moveForward(4)
        }
    }

    override fun after() {
        scoreBoard.draw(cars)
    }

    override fun hasNext(): Boolean = currentRound < round
}
