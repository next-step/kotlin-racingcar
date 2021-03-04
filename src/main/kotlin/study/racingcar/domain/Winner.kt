package study.racingcar.domain

class Winner {

    fun fetchWinners(cars: List<Car>): List<String> {
        val winners = mutableListOf<Car>()

        val maxedCar: Car = findMaxDistanceCar(cars)
        winners.addAll(findSameMaxCar(cars, maxedCar.distance))

        return winners.map(Car::name)
    }

    private fun findMaxDistanceCar(cars: List<Car>): Car {
        return requireNotNull(cars.maxBy { it.distance })
    }

    private fun findSameMaxCar(cars: List<Car>, max: Int): List<Car> {
        return cars.filter { max == it.distance }
    }
}
