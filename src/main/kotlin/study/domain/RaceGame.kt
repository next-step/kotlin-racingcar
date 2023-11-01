package study.domain

import kotlin.random.Random

class RaceGame internal constructor(
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RaceGame

        if (raceCars != other.raceCars) return false
        if (totalRound != other.totalRound) return false
        if (moveStrategy != other.moveStrategy) return false

        return true
    }

    override fun hashCode(): Int {
        var result = raceCars.hashCode()
        result = 31 * result + totalRound
        result = 31 * result + moveStrategy.hashCode()
        return result
    }

    companion object {
        fun of(carCount: Int, totalRound: Int): RaceGame {
            val raceCars = List(carCount) { RaceCar() }
            return RaceGame(raceCars, totalRound)
        }
    }
}

private const val RANDOM_NUMBER_UNTIL = 10
private const val MOVE_MINIMUM_NUMBER = 4
