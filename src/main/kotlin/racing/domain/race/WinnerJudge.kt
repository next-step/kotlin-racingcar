package racing.domain.race

import racing.domain.common.CarRaceProperty

class WinnerJudge(private val carRaceProperty: CarRaceProperty) {

    fun getWinnerCarNames(): String {
        return carRaceProperty.cars
            .filter { it.moveCount == getWinnerCount() }
            .joinToString(",") { it.carName }
    }

    private fun getWinnerCount(): Int {
        return carRaceProperty.cars
            .maxByOrNull { it.moveCount }!!
            .moveCount
    }
}
