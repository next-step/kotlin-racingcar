package racingCar.domain

object Winner {

    fun getRacingWinner(racingCars: List<Car>): String {
        val maxDistance = racingCars.map { it.distance }.max()
        return racingCars.filter { it.distance == maxDistance }.joinToString { it.name }
    }
}
