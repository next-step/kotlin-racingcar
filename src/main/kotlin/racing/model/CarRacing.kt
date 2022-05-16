package racing.model

data class CarRacing(
    val id: Int,
    var position: Int
) {

    fun movePosition(position: Int) {
        this.position = position
    }
}
