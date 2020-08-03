package carracing

object ResultView {

    fun showCarMovement(cars: List<Car>) {
        cars.forEach {
            println(it.name + " : " + "-".repeat(it.position))
        }
        println()

    }

    fun showWinners(winners: List<Car>) {
        val result = StringBuilder()
        winners.forEach {
            result.append(it.name).append(", ")
        }
        result.deleteCharAt(result.lastIndexOf(","))

        print(result.toString() + "가 최종 우승했습니다.")
    }
}
