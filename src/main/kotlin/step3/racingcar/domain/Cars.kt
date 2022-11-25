package step3.racingcar.domain

class Cars private constructor(private val elements: List<Car>) {
    fun elements(): List<Car> = elements
    fun size(): Int = elements.size
    operator fun get(index: Int) = elements[index]

    companion object {
        fun of(elements: List<Car>) = Cars(elements)
    }
}
