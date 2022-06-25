package racingcar.domain

import racingcar.domain.moving.MoveStrategy

val movingStrategy = object : MoveStrategy {
    override fun isMovable() = true
}

val notMovingStrategy = object : MoveStrategy {
    override fun isMovable() = false
}
