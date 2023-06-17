package racingcar.domain

class RacingCars(
    var list: List<RacingCar>
) {

    fun getWinners(): List<String> {
        getMaxProgress().let { maxProgress ->
            return list.filter { car -> car.progress == maxProgress }.map { it.driver }
        }
    }

    private fun getMaxProgress(): Int {
        return list.maxOf { it.progress }
    }
    companion object {
        fun of(drivers: List<String>): RacingCars {
            return drivers.map { RacingCar(progress = 1, driver = it) }.toRacingCars()
        }
    }
}

class RacingCar(
    val progress: Int = 1,
    val driver: String
) {
    fun carProgress(randomNumber: () -> Int): RacingCar {
        if (checkCanGo { randomNumber() }) {
            return RacingCar(progress.progressNext(), driver)
        }
        return RacingCar(progress, driver)
    }

    private fun checkCanGo(randomNumber: () -> Int): Boolean {
        return randomNumber() >= RESTRICT_NUMBER
    }

    companion object {
        private const val RESTRICT_NUMBER = 4
    }
}

private fun Int.progressNext() = this + 1
fun List<RacingCar>.toRacingCars() = RacingCars(this)
