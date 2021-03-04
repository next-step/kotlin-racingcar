package racingcar.domain

data class Cars(val elements: List<Car>) {

    fun move(numbers: List<Number>): Cars {
        require(elements.size == numbers.size)
        return copy(elements = elements.mapIndexed { index, car -> car.move(numbers[index]) })
    }
}
