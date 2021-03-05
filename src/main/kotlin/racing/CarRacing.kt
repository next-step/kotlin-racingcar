package racing

fun main() {
    val carCount = inputCarCount()
    val tryCount = inputTryCount()
    val cars = (1..carCount).map { Car(Probability()) }

    repeat(tryCount) {
        cars.forEach { it.tryGo() }
        printResult(cars)
    }
}
