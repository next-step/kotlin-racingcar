package race.view

import race.model.Car

object ResultView {

    private const val CAR_POSITION = "-"
    fun showResult() {
        println("실행 결과")
    }

    fun showRacing(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${CAR_POSITION.repeat(it.position)}")
        }
        println()
    }

    fun showWinner(winner: String) {
        println("$winner 가 최종우승했습니다.")
    }
}
