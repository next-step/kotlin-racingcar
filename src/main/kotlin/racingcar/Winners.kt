package racingcar

class Winners(racingCars: List<RacingCar>) {
    val cars = mutableListOf<RacingCar>()

    init {
        val winnerPosition = racingCars.maxOf { it.position }
        racingCars.forEach {
            if (it.position == winnerPosition) cars.add(it)
        }
    }
}
