package step3

data class RacingResult(
    val racingTracks: List<RacingTrack>
) {
    fun findCurrentWinners(): List<String> {
        val maxDistance = racingTracks.map { it.carDistance }.max()
        return racingTracks
            .filter { it.carDistance == maxDistance }
            .map { it.carName }
    }
}
