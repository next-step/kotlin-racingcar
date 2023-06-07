package race

data class CarPosition(
    val position: Int,
) {
    fun goForward() = copy(position = position + 1)
}
