package racingcar.model

@JvmInline
value class RacingReferee(private val history: RacingHistory) {

    init {
        require(history.isNotEmpty()) { "history must not be empty" }
    }

    val winners: RacingCars get() = history.last().farthestCars
}
