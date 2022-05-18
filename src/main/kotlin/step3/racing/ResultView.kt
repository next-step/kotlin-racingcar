package step3.racing

object ResultView {
    fun showHistory(raceHistory: RaceHistory) {
        val allHistory = raceHistory.getAllHistory()
        allHistory.forEach { round ->
            round.cars.forEach { car -> showDistance(car.name, car.distance) }
            println()
        }
    }

    fun showWinner(names: String) = println("$names 가 최종 우승했습니다.")

    private fun showDistance(name: String, distance: Int) {
        print("$name : ")
        repeat(distance) { print("-") }
        println()
    }
}
