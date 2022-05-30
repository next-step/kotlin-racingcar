package racingcar.application

import racingcar.domain.Car
import racingcar.domain.Cars

class RacingResponse(allResult: List<Cars> = emptyList()) {

    private val _allResult: MutableList<Cars> = allResult.toMutableList()
    val allResult: List<Cars>
        get() = _allResult.toList()

    val finalRound: List<Car>
        get() = _allResult.last()
            .cars
            .toList()
}

class WinnerResponse(winners: List<String> = emptyList()) {
    private val _winners: MutableList<String> = winners.toMutableList()
    val winners: List<String>
        get() = _winners.toList()
}
