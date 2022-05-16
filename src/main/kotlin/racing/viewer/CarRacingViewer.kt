package racing.viewer

import racing.model.CarRacing

class CarRacingViewer {

    fun showHowManyCars() {
        showText("자동차 대수는 몇 대인가요?")
    }

    fun showHowManyTries() {
        showText("시도할 횟수는 몇 회인가요?")
    }

    fun showGameStatus(racingCars: Array<CarRacing>) {
        racingCars.forEach {
            (0..it.position).forEach { _ -> print("-") }
            println()
        }
        println()
    }

    private fun showText(message: String) = println(message)
}
