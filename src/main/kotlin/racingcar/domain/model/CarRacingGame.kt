package racingcar.domain.model

/**
 * 자동차 경주
 */
class CarRacingGame(private val carRacers: CarRacers) {

    fun race() {
        carRacers.race()
    }

    fun result(): CarRacers {
        return carRacers.copy()
    }
}
