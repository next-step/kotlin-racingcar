package carracing.dto

data class Car(
    var name: String,
    var position: Int = 0,
) {

    fun move() {
        position++
    }
}