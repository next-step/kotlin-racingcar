package racingcar.domain

class Race(
    private val cars: List<Car>,
    private val movementCommandGenerator: MovementCommandGenerator
) {

    fun proceed(numberOfRounds: Int): List<Record> {
        require(numberOfRounds >= MINIMUM_NUMBER_OF_ROUNDS) { "경주는 최소 ${MINIMUM_NUMBER_OF_ROUNDS}번 이상 진행되어야 합니다." }

        val records = mutableListOf<Record>()

        repeat(numberOfRounds) {
            proceedRound()
            records.add(Record(cars.map { it.captureState() }))
        }

        return records.toList()
    }

    private fun proceedRound() {
        cars.forEach { it.move(movementCommandGenerator.generateMovement()) }
    }

    fun selectWinner(): List<String> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }

    private fun getMaxPosition(): Int {
        return cars.maxOf { it.position }
    }

    companion object {
        const val MINIMUM_NUMBER_OF_ROUNDS = 1
    }
}

data class Record(
    val roundRecords: List<Car.State>
)
