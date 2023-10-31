package racing

import kotlin.random.Random

object RaceExecutor {
    fun prepareCar(carCount: Int): MutableMap<Int, String> {
        val carMap = mutableMapOf<Int, String>()
        for (i in 1..carCount) {
            carMap[i] = "-"
        }
        return carMap
    }

    fun racingCarRandomly(carMap: MutableMap<Int, String>, tryCount: Int) {
        for (i in 1..tryCount) {
            // map을 순회하면서 랜덤값이 4이상이면 "-"을 추가
            for ((carNumber, value) in carMap) {
                if (getRandomValueBetween0to9() >= 4) {
                    carMap[carNumber] = "$value-"
                }
            }
            PrintResultExecutor.execute(carMap).also { println() }
        }
    }

    fun getRandomValueBetween0to9(): Int {
        return Random.nextInt(0, 9)
    }
}
