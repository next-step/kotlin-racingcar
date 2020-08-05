package racingcar.model

object Winner {

    fun find(racingCars: List<Car>): List<String> {
        val farthestDistance = getFarthestCarDistance(racingCars)
        return racingCars.filter { it.isEqualDistance(farthestDistance) }.map { it.name }
    }

    fun getFarthestCarDistance(racingCars: List<Car>) = racingCars.maxBy { it.movingDistance }?.movingDistance ?: 0
}
