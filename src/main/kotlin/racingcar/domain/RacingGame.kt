package racingcar.domain

class RacingGame(private val names: String, private var tryNo: Int) {
    private val cars: Cars =
        Cars(names.split(",").map { Car(it.trim()) })

    fun race(): Cars {
        cars.race()
        tryNo--
        return cars
    }

    fun findWinners(): Winners = cars.findWinners()

    fun isEnd(): Boolean = tryNo == 0
}
