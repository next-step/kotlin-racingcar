package step3

class Car(val name: String, var position: Int = 0) {
    init {
        require(name.length <= 5) { "Car.name 은 5자를 초과할 수 없습니다!" }
    }

    fun move() {
        position++
    }
}
