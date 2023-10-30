package carracing.dto

data class Car(var position: Int = 0) {

    fun move() {
        position++
    }
}