package racingCar

class RacingField(
    private val cars: List<Car>,
    private val gameCount: Int
) {
    constructor(carCount: Int, gameCount: Int) : this(
        List(if (carCount <= 0) 1 else carCount) { Car(randomNumber = RandomNumberGenerator()) },
        if (gameCount <= 0) 1 else gameCount
    )

    fun getGameCount(): Int {
        return gameCount
    }

    fun gameStart() {
        moveCars()
    }

    private fun moveCars() {
        cars.forEach { it.move() }
    }

    fun getCarCount(): Int {
        return cars.size
    }

    fun getCarsDistance(): List<Int> {
        return cars.map { it.readOnlyDistance }
    }
}
