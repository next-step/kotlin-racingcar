package racingcar.domain.model

interface MovingStrategy {
    fun tryMove(): Boolean
}
