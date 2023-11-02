package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingCar(val name: String, private val racingGameMoveRule: RacingGameMoveRule) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
        require(name.length in 1..5) { "자동차 이름은 1~5자만 가능합니다." }
    }

    fun moveForward() {
        if (racingGameMoveRule.isForward()) position++
    }


    fun copy(): RacingCar {
        val racingCar = RacingCar(name, racingGameMoveRule)
        racingCar.position = position
        return racingCar
    }

    override fun toString(): String {
        return "RacingCar(name='$name', position=$position)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RacingCar

        if (name != other.name) return false
        if (racingGameMoveRule != other.racingGameMoveRule) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + racingGameMoveRule.hashCode()
        result = 31 * result + position
        return result
    }
}
