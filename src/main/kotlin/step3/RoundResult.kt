package step3

data class RoundResult(
    val carPositions: List<CarPosition>
) {
    data class CarPosition private constructor(
        val name: String,
        val position: Position,
    ) {
        companion object {
            fun from(car: Car): CarPosition {
                return CarPosition(
                    name = car.name,
                    position = car.position,
                )
            }
        }
    }
}
