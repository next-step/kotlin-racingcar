package week1.racingcar

class ResultView {

    init {
        println("실행 결과")
    }

    fun showResult(cars: List<Car>) {
        cars.forEach {
            (0 until it.mileage).forEach { _ ->
                print("-")
            }
            println()
        }
        println()
    }
}