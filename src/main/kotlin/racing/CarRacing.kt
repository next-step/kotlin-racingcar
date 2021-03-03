package racing

fun main() {
    val carCount = inputCarCount()
    val tryCount = inputTryCount()
    val carList = (0 until carCount).map { Car() }.toList()

    repeat(tryCount) {
        carList.forEach { it.tryGo() }
        printResult(carList)
    }
}
