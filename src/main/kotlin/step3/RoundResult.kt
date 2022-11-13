package step3

data class RoundResult(
    val carPositions: List<CarPosition>
) {
    data class CarPosition private constructor(
        val id: Int,
        val position: Int,
    ) {
        companion object {
            fun from(car: Car): CarPosition {
                return CarPosition(
                    id = car.id,
                    position = car.position,
                )
            }
        }
    }
}
