package step3.racingcar.domain

class Cars(count: Int) {
    private val elements: List<Car> = List(count) { Car() }
    fun elements(): List<Car> = elements
    fun size(): Int = elements.size
}
