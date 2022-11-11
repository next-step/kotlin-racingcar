package racingcar

data class Record(
    val round: Round,
    val position: Position
) {
    constructor(round: Round, carRacer: CarRacer) : this(
        round = round,
        position = carRacer.position
    )
}
