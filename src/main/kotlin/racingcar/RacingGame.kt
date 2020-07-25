package racingcar

class RacingGame(val names: String, var tryNo: Int) {
    private val cars: Cars = Cars(names.split(",").map { Car(it) })

    fun race() {
        cars.race()
    }

    fun isEnd(): Boolean = tryNo == 0
}
