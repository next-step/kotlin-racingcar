package onestep.racingcar.domain

class Cars(
    private val cars: List<Car>
) {
    fun run() {
        cars.forEach(Car::run)
    }

    fun findWinners(): Cars {
        val sortedList = cars.sortedByDescending { it.position }
        return Cars(sortedList.filter { it.position == sortedList.first().position })
    }

    fun toCarNameList() = cars.map { it.name }

    override fun toString() = cars.joinToString("\n", transform = Car::toString)
}

fun List<String>.toCars() = Cars(this.map { Car.newInstance(it) })
