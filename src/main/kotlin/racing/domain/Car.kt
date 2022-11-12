package racing.domain

class Car {
    var position = 0
        private set

    fun move() {
        val randomNumber = (0..9).random()
        if (randomNumber <= 4) {
            position++
        }
    }
}
