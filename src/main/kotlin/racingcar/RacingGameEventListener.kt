package racingcar

fun interface RacingGameEventListener {

    fun notify(event: RacingGameEvent, racingGame: RacingGame)
}
