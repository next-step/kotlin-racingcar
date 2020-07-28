package step3.racing.car

interface Car {
    val name: String
    val distance: Int
    fun move()

    class NameLengthOverflowException : Exception("A car's name must be shorter.")
}
