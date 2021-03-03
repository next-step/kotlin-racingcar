package racing

fun main() {
    val carCount = inputCarCount()
    val tryCount = inputTryCount()
    val carList = (0 until carCount).map { Car(Probability()) }.toList()

    repeat(tryCount) {
        carList.forEach { it.tryGo() }
        printResult(carList)
    }
}
