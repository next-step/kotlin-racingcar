package racingcar

import kotlin.random.Random

object RacingGame {
    fun play(carNum: Int, records: GameRecords): GameRecords {
        for (i in 0 until carNum) {
            records.cars[i].move(getRandomNum())
        }
        return records
    }

    private fun getRandomNum(): Int = Random.nextInt(10)
}
