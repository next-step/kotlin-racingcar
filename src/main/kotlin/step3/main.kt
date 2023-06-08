package step3

fun main() {
    print("자동차 대수는 몇 대인가요?\n")
    val carCount = requireNotNull(readLine()).toInt()
    println("시도할 횟수는 몇 회인가요?")
    val executeCount = requireNotNull(readLine()).toInt()

    CarRacing().execute(
        carCount = carCount,
        executeCount = executeCount,
    )
}
