package racing

object View {
    fun List<List<Car>>.display() {
        this.forEach { games ->
            println("")
            games.forEach { println(it.toChar()) }
        }
    }

    private fun Car.toChar(): String =
        List(this.distance) { "-" }.joinToString(separator = "")
}
