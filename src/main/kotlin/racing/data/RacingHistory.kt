package racing.data

class RacingHistory {
    val racingStates = mutableListOf<RacingState>()

    fun add(racingState: RacingState) {
        racingStates.add(racingState)
    }
}
