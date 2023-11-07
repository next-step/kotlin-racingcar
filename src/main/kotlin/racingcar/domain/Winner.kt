package racingcar.domain

class Winner(
    private val finalRacingSituations: List<RacingSituation>,
) {

    fun evaluate(): List<RacingSituation> {
        val maxPosition = finalRacingSituations.maxOfOrNull { it.currentPosition }
        return finalRacingSituations.filter { it.currentPosition == maxPosition }
    }
}
