package racingcar.domain

class Winners(racingCars: List<RacingCar>) {
    val cars: List<RacingCar>

    init {
        val winnerPosition = racingCars.maxOf { it.position }
        cars = racingCars.filter { it.position == winnerPosition }
    }
}
