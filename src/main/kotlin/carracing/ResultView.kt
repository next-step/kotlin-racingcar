package carracing

object ResultView {

    fun showCarMovement(cars: MutableList<Car>) {
        cars.forEach {
            print(it.name + " : " + "-".repeat(it.position) + "\n")
        }
    }

    fun showWinners(winners: List<Car>) {
        val result = StringBuilder()
        winners.forEach {
            result.append(it.name).append(", ")
        }
        result.delete(result.length - 2, result.length)

        print(result.toString() + "가 최종 우승했습니다.")
    }
}
