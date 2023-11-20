package racingcar.domain

class Winner(
    private val finalRacingSituations: RacingSituations,
) {

    fun evaluate(): RacingSituations {
        val maxPosition = finalRacingSituations.maxOfOrNull()
        return finalRacingSituations.evaluate(maxPosition)
    }
}
