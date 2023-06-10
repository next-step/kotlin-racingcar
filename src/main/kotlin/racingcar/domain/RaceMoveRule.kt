package racingcar.domain

interface RaceMoveRule {
    fun canMove(car: Car): Boolean
}
