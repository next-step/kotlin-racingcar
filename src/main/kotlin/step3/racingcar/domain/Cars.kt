package step3.racingcar.domain

class Cars(val count: Int) {
    private val elements: List<Car> = List(count) { Car() }
    fun elements() = elements
    fun size() = elements.size
}
