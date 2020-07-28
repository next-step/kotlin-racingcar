package week1.step3

fun main() {
    val (carNames, tryCount) = InputView.getCarNamesAndTryCount()
    val racingCar = mutableListOf<Car>().apply {
        for (name in carNames) {
            add(Car(name))
        }
    }

    startRacing(racingCar, tryCount)
    showRacingStep(racingCar, tryCount)
}

private fun startRacing(racingCar: List<Car>, tryCount: Int) {
    repeat(tryCount) {
        racingCar.forEach { it.updateForwardCount() }
    }
}

private fun showRacingStep(racingCar: List<Car>, tryCount: Int) {
    ResultView.printRacingStep(racingCar, tryCount)
}
