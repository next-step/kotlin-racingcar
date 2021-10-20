package racingcar.domain

class Record {
    val score: String

    constructor(position: Position) {
        this.score = RACING_CAR_EMOJI.repeat(position.value)
    }

    companion object {
        private const val RACING_CAR_EMOJI = "🚘"
    }
}
