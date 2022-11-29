package racingcar.view

import racingcar.domain.car.CarName
import racingcar.domain.car.CarRacingResult

interface PromptService {
    fun getNameOfCars(assignedNames: String? = null): Set<CarName>
    fun getNumberOfMoves(assignedNumber: Int? = null): Int
    fun showResult(result: List<CarRacingResult>, winners: Set<CarName>)
}
