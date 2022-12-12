package racingcar.domain.model

/**
 * 자동차 경주
 */
class CarRacingGame(private val cars: Cars) {

    fun race() {
        cars.race()
    }

    fun result(): Cars {
        return cars.copy()
    }
}
