package racingcar.view

import racingcar.domain.car.CarName

interface PromptService {
    fun getNameOfCars(assignedNames: String? = null): Set<CarName>
    fun getNumberOfMoves(assignedNumber: Int? = null): Int
    fun showResult(result: List<Map<String, Int>>, winners: Set<CarName>)
}
