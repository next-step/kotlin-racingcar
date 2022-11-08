package step3.racingcar.domain

class Cars(val elements: MutableList<Car> = mutableListOf()) {
    fun size() = elements.size
}
