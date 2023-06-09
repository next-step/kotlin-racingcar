package step4

import kotlin.random.Random

private const val MOVE_VALUE = 4

object RacingGame {
    fun play(records: GameRecords): GameRecords {
        records.cars.keys.forEach {
            records.cars[it]!!.score += isMove(getRandomNum())
        }
        return records
    }

    fun isMove(randomNum: Int): Int {
        return if (randomNum >= MOVE_VALUE) 1 else 0
    }

    private fun getRandomNum(): Int {
        return Random.nextInt(10)
    }
}

