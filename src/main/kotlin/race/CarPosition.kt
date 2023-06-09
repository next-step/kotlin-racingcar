package race

@JvmInline
value class CarPosition(
    val position: Int,
) {
    fun goForward() = CarPosition(position = position + 1)

    companion object {
        fun getInitialCarPosition(): CarPosition {
            return CarPosition(0)
        }
    }
}
