package racing

object RaceExecutor {
    private const val CAR_RACE_FORWARD_CONDITION = 4

    fun prepareCar(carCount: Int): List<Car> {
        val cars: MutableList<Car> = mutableListOf()
        for (i in 1..carCount) {
            cars.add(Car(""))
        }
        return cars
    }

    fun raceCarRandomly(
        cars: List<Car>,
        tryCount: Int,
        randomValue: () -> Int = { RandomGenerator.getRandomValue() }
    ) {
        for (i in 1..tryCount) {
            for (car in cars) {
                if (movable(randomValue)) {
                    car.move()
                }
            }
        }
    }

    private fun movable(randomValue: () -> Int) = randomValue() >= CAR_RACE_FORWARD_CONDITION
}
