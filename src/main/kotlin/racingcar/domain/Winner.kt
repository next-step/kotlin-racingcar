package racingcar.domain

class Winner(
    private val finalRacingSituations: List<RacingSituation>,
) {

    fun evaluate(): List<RacingSituation> {
        val maxPosition = finalRacingSituations.maxOfOrNull { it.car.position }
        return finalRacingSituations.filter { it.car.position == maxPosition }
    }
}
