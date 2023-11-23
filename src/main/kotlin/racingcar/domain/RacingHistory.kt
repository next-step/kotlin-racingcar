package racingcar.domain

class RacingHistory(
    private val rounds: MutableList<List<Car>> = mutableListOf()
) {
    fun record(cars: List<Car>) {
        rounds.add(cars.map { it.copy() })
    }

    fun getRounds(): List<List<Car>> {
        return rounds
    }
}
