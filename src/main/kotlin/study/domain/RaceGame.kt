package study.domain

import kotlin.random.Random

data class RaceGame internal constructor(
    private val raceCars: List<RaceCar>,
    private val totalRound: Int,
    private val moveStrategy: () -> Boolean = fun(): Boolean =
        Random.nextInt(RANDOM_NUMBER_UNTIL) >= MOVE_MINIMUM_NUMBER,
) {
    fun play(): RaceResult {
        val raceResult = RaceResult.empty()
        repeat(totalRound) { round ->
            raceCars.forEach { car ->
                if (moveStrategy()) {
                    car.move()
                }
            }
            raceResult.recordRound(round + 1, raceCars.map { RaceCar(it.position) })
        }
        return raceResult
    }

    companion object {
        fun of(carCount: Int, totalRound: Int): RaceGame {
            val raceCars = buildList(carCount) {
                repeat(carCount) {
                    add(RaceCar())
                }
            }
            return RaceGame(raceCars, totalRound)
        }
    }
}

private const val RANDOM_NUMBER_UNTIL = 10
private const val MOVE_MINIMUM_NUMBER = 4
