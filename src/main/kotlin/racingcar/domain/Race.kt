package racingcar.domain

class Race(
    private val cars: List<Car>,
    private val numberOfRaces: Int
) {
    init {
        require(numberOfRaces >= MINIMUM_NUMBER_OF_RACES) { "경주는 최소 ${MINIMUM_NUMBER_OF_RACES}번 이상 진행되어야 합니다." }
        require(cars.isNotEmpty()) { "경주를 진행할 자동차가 없습니다." }
    }

    fun proceed(): List<Record> {
        val records = mutableListOf<Record>()

        repeat(numberOfRaces) {
            proceedRound()
            records.add(Record(cars.map { it.captureState() }))
        }

        return records.toList()
    }

    private fun proceedRound() {
        cars.forEach { it.move() }
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
        const val MINIMUM_NUMBER_OF_RACES = 1
    }
}

data class Record(
    val carStates: List<Car.State>
)
