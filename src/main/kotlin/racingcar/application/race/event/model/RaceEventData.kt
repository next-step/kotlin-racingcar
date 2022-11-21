package racingcar.application.race.event.model

sealed interface RaceEventData {
    val carData: List<CarData>
}

data class CarData(
    val name: String,
    val position: Int
)

data class RoundEventCarData(
    override val carData: List<CarData>,
    val eventState: EventState
) : RaceEventData

data class WinEventCarData(
    override val carData: List<CarData>
) : RaceEventData

enum class EventState {
    INIT, PROCESS
}
