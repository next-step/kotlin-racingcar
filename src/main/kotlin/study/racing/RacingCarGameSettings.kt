package study.racing

/**
 * @author 이상준
 */
class RacingCarGameSettings {
    fun inputBySettings(): GameSettings {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readlnOrNull()?.toInt() ?: throw NumberFormatException()

        println("시도할 횟수는 몇 회인가요?")
        val racingCount = readlnOrNull()?.toInt() ?: throw NumberFormatException()

        return GameSettings(carCount, racingCount)
    }
}

data class GameSettings(
    var carCount: Int,
    var racingCount: Int,
)
