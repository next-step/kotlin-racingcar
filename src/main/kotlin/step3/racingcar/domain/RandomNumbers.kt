package step3.racingcar.domain

class RandomNumbers {
    private var elements: MutableList<Int> = mutableListOf()
    fun add(randomNumber: Int) = elements.add(randomNumber)
    operator fun get(index: Int): Int = elements[index]
}
