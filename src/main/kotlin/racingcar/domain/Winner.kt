package racingcar.domain

class Winner(
    private val finalRacingSituation: RacingSituation,
) {

    fun evaluate(): RacingSituation {
        val maxPosition = finalRacingSituation.maxOfOrNull()
        return finalRacingSituation.evaluate(maxPosition)
    }
}
