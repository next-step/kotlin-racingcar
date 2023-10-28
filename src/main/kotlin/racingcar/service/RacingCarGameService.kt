package racingcar.service

import racingcar.domain.Racer
import racingcar.util.NumGenerator

private const val RANDOM_NUM_BOUND = 10

class RacingCarGameService(
    var racers: MutableList<Racer> = mutableListOf()
) {

    fun init(countOfRacer: Int) {
        repeat(countOfRacer) {
            racers.add(Racer())
        }
    }

    fun run(numGenerator: NumGenerator) {
        val newRacers = mutableListOf<Racer>()
        for (racer in racers) {
            val randomNum = numGenerator.getNextInt(RANDOM_NUM_BOUND)
            val nextStepRacer = racer.run(randomNum)
            newRacers.add(nextStepRacer)
        }
        racers = newRacers
    }
}
