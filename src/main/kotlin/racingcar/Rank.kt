package racingcar

object Rank {
    fun getWinnerNames(cars: List<Car>): String =
        this.getWinner(cars)
            .joinToString(",") { it.name }

    private fun getWinner(cars: List<Car>): List<Car> {
        val carsByPosition = cars.groupBy { it.position }
        val maxPosition: Int = carsByPosition.maxOf { it.key }

        return carsByPosition[maxPosition].orEmpty()
    }
}
