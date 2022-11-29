package step3.racingcar.domain

class RoundResult {
    private val elements: MutableList<Car> = mutableListOf()

    operator fun get(index: Int): Car = elements[index]
    fun add(car: Car) = elements.add(car.copy())
    fun size(): Int = elements.size
}
