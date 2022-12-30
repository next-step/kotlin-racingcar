package step3.racingcar.controller

import domain.Car
import domain.Winner
import view.RacingGameInput

class RacingGameService {
    private val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator(1, 9)
    fun race(input: RacingGameInput): Pair<String, String> {
        val candidate = input.carNames.split(",").map {
            Car(it)
        }
        var trackHistory = ""
        for (i: Int in 0..input.tryCount) {
            trackHistory += lap(candidate)
        }
        return trackHistory to Winner(candidate).getWinner()
    }

    private fun lap(candidate: List<Car>): String {
        var trackHistory = ""
        candidate.forEach {
            trackHistory += drawTrack(
                it.name,
                it.move(randomNumberGenerator.getRandomNumber())
            ) + "\n"
        }
        return trackHistory
    }

    private fun drawTrack(name: String, count: Int): String {
        var result = ""
        result += "$name : "
        for (i: Int in 0..count) {
            result += "-"
        }
        result += "\n"
        return result
    }
}

interface NumberGenerator {
    fun getRandomNumber(): Int
    val RANGE_START: Int
    val RANGE_END: Int
}

class RandomNumberGenerator(override val RANGE_START: Int, override val RANGE_END: Int) :
    NumberGenerator {
    override fun getRandomNumber() = (RANGE_START..RANGE_END).random()
}