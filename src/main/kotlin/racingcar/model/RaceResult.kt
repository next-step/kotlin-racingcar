package racingcar.model

import racingcar.exception.Exception.Companion.CASE_INCORRECT_RESULT

/**
 * 자동차 경주 최종 결과에 대한 정보를 가지고 있는 data class
 * */
data class RaceResult(
    val roundList: List<Round>,
    val winners: List<CarName>
) {
    init {
        require(roundList.isNotEmpty()) { CASE_INCORRECT_RESULT }
        require(winners.isNotEmpty()) { CASE_INCORRECT_RESULT }
    }
}
