package race

data class CarPosition(
    val position: Int,
) {
    fun goForward() = copy(position = position + 1)

    companion object {
        fun getInitialCarPosition(): CarPosition {
            return CarPosition(1)
        }
    }
}
