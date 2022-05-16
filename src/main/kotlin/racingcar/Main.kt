package racingcar

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val roundCount = readLine()!!.toInt()

    val race = Race()

    val result = race.start(carCount, roundCount)

    ResultView(result)
}

fun ResultView(result: List<Round>) {
    println("실행 결과")
    result.map {
        it.getResult().forEach {
            println(it.toString())
        }

        println()
    }
}
