package racing

class Game(
    private val cars: List<Car>,
    private val tryCount: Int
) {
    private val resultView = ResultView()

    fun start() {
        repeat(tryCount) {
            run()
        }
        
        val maxScore = cars.maxBy { it.position }.position
        val winners = cars.filter { it.position == maxScore }
        resultView.viewWinner(winners.map { it.name })
    }

    private fun run() {
        cars.forEach {
            it.move()
        }

        resultView.view(cars)
    }
}
