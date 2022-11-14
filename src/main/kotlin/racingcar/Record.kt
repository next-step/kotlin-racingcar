package racingcar

data class Record(
    val round: Round,
    val name: Name,
    val position: Position
) {
    constructor(round: Round, carRacer: CarRacer) : this(
        round = round,
        name = carRacer.name,
        position = carRacer.position
    )
}
