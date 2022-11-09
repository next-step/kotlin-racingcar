package step3.model

data class DefaultCar(private var track: String = "") : Car {
    override fun getTrack(): String = track

    override fun goForward() {
        track += DEFAULT_TRACK
    }

    override fun copy(): Car = copy(track = track)

    companion object {
        private const val DEFAULT_TRACK = "-"
    }
}
