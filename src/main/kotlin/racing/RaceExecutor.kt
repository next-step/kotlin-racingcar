package racing

object RaceExecutor {
    private const val CAR_RACE_FORWARD_CONDITION = 4

    fun prepareCar(carCount: Int): List<Car> {
        val carList: MutableList<Car> = mutableListOf()
        for (i in 1..carCount) {
            carList.add(Car(""))
        }
        return carList
    }

    fun raceCarRandomly(
        carList: List<Car>,
        tryCount: Int,
        randomValue: () -> Int = { RandomGenerator.getRandomValue() }
    ) {
        for (i in 1..tryCount) {
            for (car in carList) {
                if (movable(randomValue)) {
                    car.move()
                }
            }
        }
    }

    private fun movable(randomValue: () -> Int) = randomValue() >= CAR_RACE_FORWARD_CONDITION
}
