package racingcar.application.race

sealed interface RaceData {
    val carData: List<CarData>
}

data class CarData(
    val name: String,
    val position: Int
)

data class RoundCarData(
    override val carData: List<CarData>
) : RaceData

data class WinCarData(
    override val carData: List<CarData>
) : RaceData
