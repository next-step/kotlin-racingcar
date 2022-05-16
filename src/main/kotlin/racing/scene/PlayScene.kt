package racing.scene

import racing.engine.EnvironmentManager
import racing.model.Cars
import racing.model.ScoreBoard
import racing.port.OutputPainter
import racing.port.RandomGeneratorPort
import racing.utils.Constants

class PlayScene(
    private val outputPainter: OutputPainter,
    private val scoreBoard: ScoreBoard,
    private val randomGenerator: RandomGeneratorPort,
    private val environmentManager: EnvironmentManager,
) : Scene {

    private var currentRound = 1
    private var totalRound = 0
    private var cars: Cars = Cars.empty()

    override fun run() {
        start()
        do {
            update()
        } while (hasNext())
        end()
    }

    private fun start() {
        setUpTotalRound()
        setUpCars()
        printPrologue()
    }

    private fun update() {
        moveCars()
        drawCars()
        outputSplitLine()
    }

    private fun end() {
        outputWinners()
    }

    private fun hasNext(): Boolean = currentRound++ < totalRound

    private fun setUpCars() {
        val carNames = environmentManager.getOrDefault(Constants.CAR_NAMES_KEY, "")
        cars = Cars.createWithNames(carNames)
    }

    private fun setUpTotalRound() {
        totalRound = environmentManager.getOrDefault(Constants.STAGE_NUMBER_KEY, "0").toInt()
    }

    private fun drawCars() {
        scoreBoard.draw(cars)
    }

    private fun moveCars() {
        cars = cars.moveAll(randomGenerator)
    }

    private fun outputSplitLine() {
        outputPainter.draw("\n\n")
    }

    private fun printPrologue() {
        outputPainter.draw("\n실행결과\n")
    }

    private fun outputWinners() {
        outputPainter.draw("${cars.getWinners()}가 최종 우승했습니다.")
    }
}
