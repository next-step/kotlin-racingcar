package study.racingcar

class Winner {

    fun fetchWinners(cars: List<Car>): List<String> {
        val winners = mutableListOf<Car>()
        val sortedCars = cars.sortedByDescending { it.distance }
        val max: Car = sortedCars[0]

        winners.add(max)
        sortedCars.subList(1, sortedCars.size)
            .find { it.distance == max.distance }
            ?.let(winners::add)

        return winners.map(Car::name)
    }
}
