package racingcar

// 실행하게될
class Application

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("자동차 대수는 숫자여야 합니다.")
    require(carCount > 0) { throw IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.") }


    print("시도할 횟수는 몇 회인가요?")
    val moveCount = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("시도할 횟수는 숫자여야 합니다.")
    require(moveCount > 0) { "시도 횟수는 1 이상이어야 합니다." }
}
