package RacingcarWinner.Domain

class Car(name: String, position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    val name: String = name

    fun move(orders: Int) {
        if (orders == 1) position++
    }

    companion object {

        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

fun main() {
    val carsample = Car("joseph")
    println(carsample.position.toInt())
}
