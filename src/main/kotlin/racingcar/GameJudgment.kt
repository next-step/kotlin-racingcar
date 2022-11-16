package racingcar

data class GameJudgment(
    val cars: List<Car>,
) {
    fun getWinners(): List<String> {
        val winningScore = cars.maxOf { it.currentPosition }

        return cars
            .filter { it.currentPosition == winningScore }
            .map { it.name }
    }
}
