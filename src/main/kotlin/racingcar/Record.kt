package racingcar

data class Record(
    val count: Int,
    val carRacer: CarRacer,
    val position: Position
) {
    constructor(count: Int, carRacer: CarRacer) : this(
        count = count,
        carRacer = carRacer,
        position = carRacer.position
    )
}
