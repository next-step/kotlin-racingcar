package racingcar

data class RacingGame(val cars: List<Car>) {
    fun play(randomNumStrategy: MoveStrategy) {
        this.cars.forEach { it.move(randomNumStrategy) }
    }

    fun getWinners(): List<Car> {
        val max = this.cars.maxBy { it.score }.score
        return cars.filter { it.score == max }
    }
}
