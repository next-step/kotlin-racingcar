package racingcar

data class Record(
    val round: Int,
    val carRacer: CarRacer,
    val position: Position
) {
    constructor(round: Int, carRacer: CarRacer) : this(
        round = round,
        carRacer = carRacer,
        position = carRacer.position
    )
}
