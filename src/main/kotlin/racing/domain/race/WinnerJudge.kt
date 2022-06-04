package racing.domain.race

import racing.domain.common.CarRaceProperty
import racing.domain.exception.CarRacePropertyErrorException

class WinnerJudge(private val carRaceProperty: CarRaceProperty) {

    fun getWinnerCarNames(): String {
        return carRaceProperty.cars
            .filter { it.moveCount == getWinnerCount() }
            .joinToString(",") { it.carName }
    }

    private fun getWinnerCount(): Int {
        return carRaceProperty.cars
            .maxByOrNull { it.moveCount }
            ?.moveCount ?: throw CarRacePropertyErrorException("Car 속성 중 moveCount가 null입니다.")
    }
}
