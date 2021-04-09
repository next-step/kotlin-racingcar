package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy

data class Cars(val elements: List<Car>) {

    val maxDistance
        get() = (elements.max() ?: throw IllegalStateException())
            .distance

    fun move(moveStrategies: List<MoveStrategy>): Cars {
        require(elements.size == moveStrategies.size)
        return copy(elements = elements.mapIndexed { index, car -> car.move(moveStrategies[index]) })
    }

    fun findAllByDistance(distance: Distance) = elements.filter { it.isSameDistance(distance) }
}
