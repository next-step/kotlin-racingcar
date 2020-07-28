package week1.step3

fun main() {
    val (carCount, tryCount) = InputView.getCarAndTryCount()
    val racingCar = Array(carCount) { Car() }

    showContent(tryCount, racingCar)
}

private fun showContent(tryCount: Int, racingCar: Array<Car>) {
    repeat(tryCount) {
        ResultView.printEachCarMovingState(racingCar)
        racingCar.forEach { it.updateForwardCount() }
        println()
    }
}
