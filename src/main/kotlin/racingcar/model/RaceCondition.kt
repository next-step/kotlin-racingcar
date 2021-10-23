package racingcar.model

import racingcar.exception.Exception.Companion.CASE_INPUT_DATA_WRONG
import racingcar.exception.Exception.Companion.CASE_ZERO_RACING_ROUND

data class RaceCondition(
    val carsName: List<CarName>,
    val tryCount: Int
) {
    init {
        require(tryCount > 0) { CASE_ZERO_RACING_ROUND }
        require(carsName.isNotEmpty()) { CASE_INPUT_DATA_WRONG }
    }
}
