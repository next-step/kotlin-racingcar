package racing

data class Car(private var position: Int = 1) {
    fun getResult(): String = (1..position).map { "-" }.reduce { a, b -> a + b }

    fun move() {
        position += 1
    }
}
