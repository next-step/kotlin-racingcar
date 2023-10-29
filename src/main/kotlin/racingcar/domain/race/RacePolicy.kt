package racingcar.domain.race

interface RacePolicy {
    val moveAmount: Int
    val moveCondition: () -> Boolean
}
