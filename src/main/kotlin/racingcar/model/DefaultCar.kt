package racingcar.model

data class DefaultCar(override val track: String = "") : Car {

    override fun goForward(): Car = DefaultCar(track + DEFAULT_TRACK)

    companion object {
        private const val DEFAULT_TRACK = "-"
    }
}
