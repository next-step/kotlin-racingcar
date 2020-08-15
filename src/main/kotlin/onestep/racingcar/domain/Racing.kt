package onestep.racingcar.domain

class Racing(
    carNames: List<String>,
    private val tryCount: Int,
    private val cars: List<Car> = carNames.map { Car.newInstance(it) }
) {

    fun race(show: (List<Car>) -> Unit): List<Car> {
        repeat(tryCount) {
            cars.map(Car::run)
            show(cars)
        }
        return findWinner(cars)
    }

    private fun findWinner(cars: List<Car>): List<Car> {
        val sortedList = cars.sortedByDescending { it.position }
        return sortedList.filter { it.position == sortedList.first().position }
    }
}
