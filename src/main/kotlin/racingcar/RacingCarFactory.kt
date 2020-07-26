package racingcar

object RacingCarFactory {
    val cars = mutableListOf<RacingCar>()

    fun makeCar(): RacingCar {
        val car = RacingCar()
        cars.add(car)
        return car
    }
}
