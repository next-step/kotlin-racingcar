package racingCar.ui

import racingCar.domain.Cars
import racingCar.domain.RaceResult

class RaceResultStorage : RaceResult {

    private var round: Int = 0
    private val results: MutableList<RoundResult> = mutableListOf()

    override fun save(cars: Cars) {
        val carMoveResults = cars.cars.map {
            CarMoveResult(it.name.value, it.position.value)
        }
        val roundResult = RoundResult(++round, carMoveResults)
        results.add(roundResult)
    }

    fun getRoundResults(): List<RoundResult> {
        return results.sortedBy { it.round }.toList()
    }

    fun getWinners(): List<CarMoveResult> {
        val finalRoundResult = getFinalRoundResult().results
        val maxPosition = finalRoundResult.maxOf { it.position }
        return finalRoundResult.filter { it.position == maxPosition }
    }

    private fun getFinalRoundResult(): RoundResult {
        return results.sortedByDescending { it.round }[0]
    }
}

data class RoundResult(
    val round: Int,
    val results: List<CarMoveResult>
)

data class CarMoveResult(
    val name: String,
    val position: Int,
)
