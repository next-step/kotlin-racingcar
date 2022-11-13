package racingcar.model

data class GameInfo(
    val carInfo: CarInfo,
    val trialCount: Int,
)

data class CarInfo(
    val names: List<String>,
    val count: Int,
)
