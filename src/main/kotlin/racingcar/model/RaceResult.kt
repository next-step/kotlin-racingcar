package racingcar.model

/**
 * 자동차 경주 최종 결과에 대한 정보를 가지고 있는 data class
 * */
data class RaceResult(
    val roundList: List<Round>,
    val winners: List<CarName>
)
