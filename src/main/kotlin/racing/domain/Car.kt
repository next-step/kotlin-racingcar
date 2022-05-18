package racing.domain

class Car(
    val name: String,
) {
    var position: Int
        private set

    init {
        position = DEFAULT_POSITION
    }

    fun movePosition() {
        position += 1
    }

    companion object{
        const val DEFAULT_POSITION: Int = 0
    }

}

fun List<Car>.extractWinner(): List<String> {
    val longestPosition = this.maxOf { it.position }

    return this.filter { it.position == longestPosition }
        .map { it.name }
        .toList()
}
