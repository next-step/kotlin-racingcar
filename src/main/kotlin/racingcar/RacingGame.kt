package racingcar

class RacingGame(val names: String, var tryNo: Int) {
    private val cars: Cars = Cars(names.split(",").map { Car(it) })

    fun race(): Cars {
        cars.race()
        tryNo--
        return cars
    }

    fun findWinners(): Winners = cars.findWinners()

    fun isEnd(): Boolean = tryNo == 0
}
