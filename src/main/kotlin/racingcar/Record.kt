package racingcar

data class Record(
    val round: Int,
    val position: Position
) {
    constructor(round: Int, carRacer: CarRacer) : this(
        round = round,
        position = carRacer.position
    )
}
