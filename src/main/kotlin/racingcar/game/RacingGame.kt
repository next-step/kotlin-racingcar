package racingcar.game

import racingcar.car.Cars

class RacingGame(
    val cars: Cars,
    private val round: Round,
) {
    constructor(
        carNames: List<String>,
        round: Int,
    ) : this(
        Cars.fromNames(carNames),
        Round(round),
    )

    val canStart: Boolean
        get() = round.canContinue

    fun play() {
        check(canStart) {
            "There is no round to play."
        }

        cars.moveAll()
        round.proceed()
    }
}
