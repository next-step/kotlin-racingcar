package racingcar

class RacingGame(private val carCount: Int, private val tryCount: Int) {
    val driverList = List(this.carCount) { Driver(Car()) }

    fun start() {
        repeat(tryCount) {
            driverList.forEach {
                val isMovable = (0..9).random() >= 4
                it.drive(isMovable)
            }
        }
    }
}
