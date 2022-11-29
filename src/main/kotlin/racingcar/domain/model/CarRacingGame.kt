package racingcar.domain.model

/**
 * 자동차 경주
 */
class CarRacingGame(private val carRacers: List<CarRacer>) {

    fun race() {
        carRacers.forEach { racer ->
            racer.moveTo(count = (0..9).random())
        }
    }

    fun result(): List<CarRacer> {
        return carRacers
            .map { racer ->
                CarRacer.ofCarRacer(racer = racer)
            }
    }
}
