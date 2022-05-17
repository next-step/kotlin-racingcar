package racing.scene

import racing.dto.InputDto
import racing.model.Cars
import racing.model.ScoreBoard
import racing.port.OutputPainter
import racing.port.RandomGeneratorPort

class PlayScene(
    inputDto: InputDto,
    private val painter: OutputPainter,
    private val randomGenerator: RandomGeneratorPort,
) {

    private var currentRound = 1
    private var totalRound = inputDto.round
    private var cars: Cars = inputDto.cars
    private val history = mutableListOf<Cars>()

    fun run(): ScoreBoard {
        do {
            moveCars()
            drawCars()
        } while (hasNext())
        return ScoreBoard(history, painter)
    }

    private fun hasNext(): Boolean = currentRound++ < totalRound

    private fun drawCars() {
        history.add(cars)
    }

    private fun moveCars() {
        cars = cars.moveAll(randomGenerator)
    }
}
