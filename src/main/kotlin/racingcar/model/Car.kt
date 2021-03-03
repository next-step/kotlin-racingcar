package racingcar.model

data class Car(private val locationTracker: LocationTracker = LocationTracker()) {

    fun tryMove(canGo: Boolean) {
        if (canGo) locationTracker.update(1)
    }

    fun whereIs() = locationTracker.getCurrentState()

    companion object {
        fun create() = Car()
    }
}
