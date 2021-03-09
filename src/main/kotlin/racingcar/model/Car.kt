package racingcar.model

data class Car(private val locationTracker: LocationTracker = LocationTracker(), private val name: String) {

    fun tryMove(canGo: Boolean) {
        if (canGo) locationTracker.update(1)
    }

    fun whereIs() = locationTracker.getCurrentState()

    companion object {
        fun create(name: String) = Car(name = name)
    }

    override fun toString(): String {
        return name
    }
}
