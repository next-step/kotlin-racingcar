package racingCar2

class ResultView {
    fun showResultMessage() {
        println("실행 결과")
    }

    fun showGameResult(cars: List<Car>) {
        cars.forEach {
            showCarPosition(it)
        }
        println()
    }

    fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun showCarPosition(car: Car) {
        println("${car.name} : ${DISPLAY_STRING.repeat(car.position)}")
    }

    companion object {
        const val DISPLAY_STRING = "-"
    }
}
