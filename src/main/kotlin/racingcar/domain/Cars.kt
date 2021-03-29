package racingcar.domain

data class Cars(val elements: List<Car>) {

    val maxDistance
        get() = (elements.max() ?: throw IllegalStateException())
            .distance

    fun move(numbers: List<Number>): Cars {
        require(elements.size == numbers.size)
        return copy(elements = elements.mapIndexed { index, car -> car.move(numbers[index]) })
    }

    fun findAllByDistance(distance: Distance) = elements.filter { it.isSameDistance(distance) }
}
