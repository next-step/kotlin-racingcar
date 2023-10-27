package study.domain

import kotlin.random.Random

data class RaceGame internal constructor(
    private val raceCars: List<RaceCar>,
    private val totalRound: Int,
    private val moveStrategy: () -> Boolean = fun(): Boolean = Random.nextInt(10) >= 4,
) {
    fun play(): RaceResult {
        val raceResult = RaceResult.empty()
        repeat(totalRound) { round ->
            raceCars.forEach { car ->
                if (moveStrategy.invoke()) {
                    car.move()
                }
            }
            raceResult.recordRound(round + 1, raceCars.map { it.copy() })
        }
        return raceResult
    }

    companion object {
        fun of(carCount: Int, totalRound: Int): RaceGame {
            val raceCars = mutableListOf<RaceCar>()
            repeat(carCount) {
                raceCars.add(RaceCar())
            }
            return RaceGame(raceCars, totalRound)
        }
    }
}
