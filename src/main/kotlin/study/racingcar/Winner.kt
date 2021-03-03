package study.racingcar

class Winner {

    fun fetchWinners(cars: List<Car>): List<String> {
        val winners = mutableListOf<Car>()
        val sortedCars = cars.sortedByDescending { it.distance }
        val max: Car = sortedCars[0]

        winners.add(max)
        val sameMaxCars = sortedCars.subList(1, sortedCars.size)
            .filter { it.distance == max.distance }
            .toList()
        winners.addAll(sameMaxCars)

        return winners.map(Car::name)
    }
}
