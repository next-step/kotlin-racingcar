package step3.model

class DefaultCar private constructor(private var track: String) : Car {
    override fun getTrack(): String = track
    override fun goForward() {
        track += DEFAULT_TRACK
    }

    companion object {
        private const val DEFAULT_TRACK = "-"
        operator fun invoke(): DefaultCar = DefaultCar("")
    }
}
