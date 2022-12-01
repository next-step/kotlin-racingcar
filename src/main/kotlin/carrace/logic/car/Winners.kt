package carrace.logic.car

data class Winners(
    val cars: List<Car>
) {

    companion object {
        fun from(cars: List<Car>): Winners {
            val highestScore = cars.maxOf { car -> car.carPosition.position }
            return Winners(
                cars.filter { car ->
                    car.carPosition.position == highestScore
                }
            )
        }
    }
}
