package camp.nextstep.edu.racingcar.racing

class Winner private constructor(winner: Car) {

    val id = winner.id
    val name = winner.name

    companion object {
        fun of(racing: Racing): Set<Winner> {
            val racingResults = racing.carRacingEvents().map { it.key to CarRaceEvent.merge(it.value).marks() }
            val winnersCount = racingResults.maxOf { it.second }

            return racingResults.filter { it.second == winnersCount }.map { Winner(it.first) }.toSet()
        }
    }
}
