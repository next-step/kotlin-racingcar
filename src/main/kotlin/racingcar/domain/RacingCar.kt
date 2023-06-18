package racingcar.domain

class RacingCars(
    var list: List<RacingCar>
) {

    fun getWinners(): List<String> {
        return getMaxProgress().let { maxProgress ->
            list.filter { car -> car.progress == maxProgress }.map { it.driver }
        }
    }

    private fun getMaxProgress(): Int {
        return list.maxOf { it.progress }
    }

    companion object {
        fun of(drivers: List<String>): RacingCars {
            return drivers.map { RacingCar(driver = it) }.toRacingCars()
        }
    }
}

class RacingCar(
    val progress: Int = 1,
    val driver: String
) {

    init {
        if (driver.length > MINIMUM_DRIVER_LENGTH) {
            throw IllegalArgumentException("문자열의 길이가 6자 이상인 항목이 있습니다.")
        }
    }

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
        private const val MINIMUM_DRIVER_LENGTH = 5
    }
}

private fun Int.progressNext() = this + 1
fun List<RacingCar>.toRacingCars() = RacingCars(this)
