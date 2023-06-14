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

    private fun showCarPosition(car: Car) {
        println("${car.name} : ${DISPLAY_STRING.repeat(car.position)}")
    }

    companion object {
        const val DISPLAY_STRING = "-"
    }
}
