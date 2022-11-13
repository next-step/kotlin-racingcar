package racingcar

data class InputView(
    val cars: List<Car> = readCars("자동차 대수는 몇 대인가요?"),
    val roundCount: Int = readRoundCount("시도할 횟수는 몇 회인가요?"),
)

private fun readCars(message: String): List<Car> {
    println(message)

    val list = mutableListOf<Car>()
    repeat(readln().toInt()) {
        list.add(Car())
    }

    return list
}

private fun readRoundCount(message: String): Int {
    println(message)
    return readln().toInt()
}
