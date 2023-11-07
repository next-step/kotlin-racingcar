package racingcar.domain

class Winner(
    private val finalRacingResult: List<RacingResult>,
) {

    fun evaluate(): List<RacingResult> {
        val maxPosition = finalRacingResult.maxOfOrNull { it.resultPosition }
        return finalRacingResult.filter { it.resultPosition == maxPosition }
    }
}
