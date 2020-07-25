package racingcar

class RacingGame(val names: String, var tryNo: Int) {
    private val cars: Cars = Cars(names.split(",").map { Car(it) })

    fun race() {
        cars.race()
    }

    fun isEnd(): Boolean {
       if (tryNo == 0)
           return true
       return false
    }
}
