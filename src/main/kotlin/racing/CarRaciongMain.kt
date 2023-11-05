package racing

fun main() {
    startCarRacing()
}

fun startCarRacing() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readln().toInt()

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readln().toInt()

    val carMap = RaceExecutor.prepareCar(carCount)
    RaceExecutor.racingCarRandomly(carMap, tryCount)
}
