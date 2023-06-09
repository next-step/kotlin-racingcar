package racing

import kotlin.random.Random

private const val MOVE_VALUE = 4

object RacingGame {
    fun play(carNum: Int, records: GameRecords): GameRecords {
        for (i in 0 until carNum) {
            records.records[i] += isMove(getRandomNum())
        }
        return records
    }

    fun isMove(randomNum: Int): Int = if (randomNum >= MOVE_VALUE) 1 else 0

    private fun getRandomNum(): Int = Random.nextInt(10)
}
