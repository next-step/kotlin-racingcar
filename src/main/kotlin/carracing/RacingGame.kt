package carracing

import carracing.dto.RacingRound
import java.util.Random

class RacingGame(
    private val carCount: Int,
    private val racingCount: Int
) {
    fun start(): List<RacingRound> {
        return mutableListOf<RacingRound>().apply {
            repeat(racingCount) { round ->
                val roundResult = playGame(round)
                if (round > 0) roundResult.setResult(this[round - 1])
                this.add(roundResult)
            }
        }
    }

    fun playGame(round: Int): RacingRound {
        val racing = RacingRound.of(round, carCount)
        racing.cars.forEach {
            if (isMove()) {
                it.move()
            }
            racing.result.add(it)
        }
        return racing
    }

    private fun isMove(): Boolean {
        val num = Random().nextInt(RANDOM_RANGE)
        return num >= MOVE_VALUE
    }

    companion object {
        private const val RANDOM_RANGE = 10
        private const val MOVE_VALUE = 4
    }
}