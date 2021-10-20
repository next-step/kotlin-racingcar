package racingcar.model

import racingcar.exception.Exception.Companion.CASE_ZERO_RACING_ROUND
import racingcar.exception.Exception.Companion.CASE_ZERO_WINNER

/**
 * 경주 1번에 대한 정보 class
 * */
data class Round(
    val round: Int,
    val roundResult: List<Car>
) {
    init {
        require(round >= 0) { CASE_ZERO_RACING_ROUND }
        require(roundResult.isNotEmpty()) { CASE_ZERO_WINNER }
    }
}
