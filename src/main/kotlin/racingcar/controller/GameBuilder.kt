package racingcar.controller

import racingcar.model.RacingGame

interface GameBuilder<T> {
    fun createGame(argument: T): RacingGame
}
