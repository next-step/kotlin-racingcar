package racingcar.domain

import racingcar.util.NumGenerator

private const val RANDOM_NUM_BOUND = 10

class RacingCarGame(
    val racers: List<Racer>
) {

    companion object {
        fun init(racers: List<Racer>): RacingCarGame {
            return RacingCarGame(racers)
        }
    }

    fun race(numGenerator: NumGenerator): RacingCarGame {
        val newRacers = mutableListOf<Racer>()
        for (racer in racers) {
            val randomNum = numGenerator.getNextInt(RANDOM_NUM_BOUND)
            val nextStepRacer = racer.moveOrStop(randomNum)
            newRacers.add(nextStepRacer)
        }
        return RacingCarGame(newRacers)
    }
}
