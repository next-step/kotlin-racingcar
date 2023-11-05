package racing

object RaceExecutor {
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
                if (randomValue() >= 4) {
                    car.move()
                }
            }
            PrintResultExecutor.execute(carList).also { println() }
        }
    }
}
