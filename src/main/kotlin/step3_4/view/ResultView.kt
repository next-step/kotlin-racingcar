package step3_4.view

import step3_4.racing.Car

object ResultView {
    fun showResult(carList: List<Car>) {
        carList.forEach { car ->
            showSingleCarRacingResult(car)
        }
        println()
    }

    private fun showSingleCarRacingResult(car: Car) {
        print("${car.carName} : ")
        for (i in MINIMUM_STEP..car.currentStep()) {
            print("-")
        }
        println()
    }

    fun showLastResult(carList: List<Car>) {
        val winnerStep = carList.maxOf { it.currentStep() }
        val winnersCarList = carList.sortedByDescending { it.currentStep() }.filter { it.currentStep() == winnerStep }
        val winnersCarName = winnersCarList.joinToString(SEPARATOR) { it.carName }
        println("$winnersCarName$IS_FINAL_WINNER")
    }

    private const val MINIMUM_STEP = 1
    private const val IS_FINAL_WINNER = "(이)가 최종 우승했습니다."
    private const val SEPARATOR = ","
}
