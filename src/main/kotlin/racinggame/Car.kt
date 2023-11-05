package racinggame

data class Car(val name: String, val driveLength: Int = 0) {
    var forwardValue = "-"

    fun goForward(value: Int) {
        forwardValue = if (value > 4) "-$forwardValue" else forwardValue
    }
}