package racingcar.domain

data class RacingSituations(
    val racingSituations: List<RacingSituation>,
) {

    fun maxOfOrNull(): Int? {
        return racingSituations.maxOfOrNull { it.car.position }
    }

    fun evaluate(maxPosition: Int?): RacingSituations {
        return RacingSituations(racingSituations.filter { it.car.position == maxPosition })
    }
}
