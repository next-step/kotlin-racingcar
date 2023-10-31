package week1.racingcar

class ResultView {

    init {
        println("실행 결과")
    }

    fun showResult(cars: List<Car>) {
        cars.forEach {
            print("${it.name} : ")
            (0 until it.mileage).forEach { _ ->
                print("-")
            }
            println()
        }
        println()
    }

    fun showWinner(winners: List<String>) {
        winners.forEachIndexed { idx, winner ->
            print(winner)
            if (idx < winners.lastIndex) print(", ")
        }
        println("가 최종 우승했습니다.")
    }
}