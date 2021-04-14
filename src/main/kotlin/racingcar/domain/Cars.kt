package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy

data class Cars(val elements: List<Car>) {

    constructor(vararg elements: Car) : this(elements.toList())

    val maxDistance
        get() = (elements.max() ?: throw IllegalStateException())
            .distance

    fun move(moveStrategy: MoveStrategy) = copy(elements = elements.map { it.move(moveStrategy) })

    fun findAllByDistance(distance: Distance) = elements.filter { it.isSameDistance(distance) }
}
