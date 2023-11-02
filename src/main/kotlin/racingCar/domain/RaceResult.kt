package racingCar.domain

class RaceResult {

    private var round: Int = 0
    private val results: MutableList<RoundResult> = mutableListOf()

    fun save(cars: Cars) {
        val carMoveResults = cars.cars.map {
            CarMoveResult(it.name.value, it.position.value)
        }
        val roundResult = RoundResult(++round, carMoveResults)
        results.add(roundResult)
    }

    fun getRoundResults(): List<RoundResult> {
        return results.sortedBy { it.round }.toList()
    }

    data class RoundResult(
        val round: Int,
        val results: List<CarMoveResult>
    )

    data class CarMoveResult(
        val name: String,
        val position: Int,
    )
}
