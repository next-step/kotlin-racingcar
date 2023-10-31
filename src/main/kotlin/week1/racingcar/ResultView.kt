package week1.racingcar

class ResultView {

    fun showResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach {
            print("${it.name} : ")
            println("-".repeat(it.mileage))
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