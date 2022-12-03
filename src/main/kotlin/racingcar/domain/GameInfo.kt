package racingcar.domain

data class GameInfo(
    val carInfo: CarInfo,
    val trialCount: Int,
)

data class CarInfo(
    val names: List<Name>,
    val count: Int,
)
