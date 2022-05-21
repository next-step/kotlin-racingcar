package racing.race

import racing.common.CarRaceProperty

class WinnerJudge(private val carRaceProperty: CarRaceProperty) {

    fun getWinnerCarNames(): String {
        return carRaceProperty.cars
            .filter { it.getMoveCount() == getWinnerCount() }
            .joinToString(",") { it.getCarName() }
    }

    private fun getWinnerCount(): Int {
        return carRaceProperty.cars
            .maxByOrNull { it.getMoveCount() }!!
            .getMoveCount()
    }
}
