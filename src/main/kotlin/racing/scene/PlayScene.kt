package racing.scene

import racing.dto.InputDto
import racing.model.Cars
import racing.port.RandomGeneratorPort

class PlayScene(
    inputDto: InputDto,
    private val randomGenerator: RandomGeneratorPort,
) {

    private var currentRound = 1
    private var cars: Cars = Cars.createWithNames(inputDto.names)
    private val totalRound = inputDto.round
    private val roundHistory = mutableListOf<Cars>()

    fun playGame(): List<Cars> {
        do {
            moveCars()
            recordHistory()
        } while (hasNext())
        return roundHistory
    }

    private fun hasNext(): Boolean = currentRound++ < totalRound

    private fun recordHistory() {
        roundHistory.add(cars)
    }

    private fun moveCars() {
        cars = cars.moveAll(randomGenerator)
    }
}
