package camp.nextstep.edu.racingcar.racing

class Winner private constructor(winner: Car) {

    val id = winner.id
    val name = winner.name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Winner

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    companion object {
        fun of(racing: Racing): Set<Winner> {
            val racingResults = racing.carRacingEvents().map { it.key to CarRaceEvent.merge(it.value).marks() }
            val winnersCount = racingResults.maxOf { it.second }

            return racingResults.filter { it.second == winnersCount }.map { Winner(it.first) }.toSet()
        }
    }
}
