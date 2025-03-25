package racingcar.game

import racingcar.car.Cars

class RacingGame(
    val cars: Cars,
    private val round: Round,
) {
    val playable: Boolean
        get() = round.canContinue

    constructor(
        carNames: List<String>,
        round: Int,
    ) : this(
        Cars.fromNames(carNames),
        Round(round),
    )

    fun play() {
        check(playable) {
            "There is no more round left to play."
        }

        cars.moveAll()
        round.proceed()
    }
}
