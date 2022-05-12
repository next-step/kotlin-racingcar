package scene

import engine.EnvironmentManager
import model.Car
import model.ScoreBoard
import port.OutputPainter
import utils.RandomGenerator

class PlayScene(
    private val outputPainter: OutputPainter,
    private val scoreBoard: ScoreBoard,
    private val randomGenerator: RandomGenerator,
) : Scene {

    private var currentRound = 1
    private var totalRound = 0
    private var cars: List<Car> = emptyList()

    override fun before() {
        setUpTotalRound()
        setUpCars()
        printPrologue()
    }

    override fun update() {
        moveCars()
        drawCars()
        splitStageLine()
    }

    override fun after() {
    }

    override fun hasNext(): Boolean = currentRound++ < totalRound

    private fun setUpCars() {
        val carNumber = EnvironmentManager.getOrDefault("CAR_NUMBER", "0").toInt()
        cars = MutableList(carNumber) { Car.spawnAt(0) }
    }

    private fun setUpTotalRound() {
        totalRound = EnvironmentManager.getOrDefault("STAGE_NUMBER", "0").toInt()
    }

    private fun drawCars() {
        scoreBoard.draw(cars)
    }

    private fun moveCars() {
        cars = cars.map {
            it.moveForward(randomGenerator.generate())
        }
    }

    private fun splitStageLine() {
        outputPainter.draw("\n")
    }

    private fun printPrologue() {
        outputPainter.draw("\n실행결과\n")
    }
}
