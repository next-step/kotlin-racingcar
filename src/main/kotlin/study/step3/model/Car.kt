package study.step3.model

class Car {
    private var location: Int = 0;

    fun advance() {
        location++
    }

    fun location(): Int = location
}
