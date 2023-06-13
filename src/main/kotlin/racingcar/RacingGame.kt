package racingcar

data class RacingGame(val cars: List<Car>) {
    fun play(randomNumStrategy: MoveStrategy) {
        this.cars.forEach { it.move(randomNumStrategy) }
    }
}
