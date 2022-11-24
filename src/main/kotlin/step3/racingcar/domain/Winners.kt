package step3.racingcar.domain

class Winners private constructor(cars: Cars) {
    val names: String = formatToWinnerNames(cars, findMaxDistance(cars))

    private fun findMaxDistance(cars: Cars) = cars.elements().maxOf { it.distance }

    private fun formatToWinnerNames(cars: Cars, maxDistance: Int): String {

        return findWinnerNames(cars, maxDistance).joinToString(WINNER_NAME_JOINING_SEPARATOR)
    }

    private fun findWinnerNames(cars: Cars, maxDistance: Int) =
        cars.elements()
            .filter { it.distance == maxDistance }
            .map { it.name }

    companion object {
        private const val WINNER_NAME_JOINING_SEPARATOR = ", "
        fun of(cars: Cars): Winners = Winners(cars)
    }
}
