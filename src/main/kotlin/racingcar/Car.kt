package racingcar

class Car {
    private var currentLocation: String = ""

    fun go(number: Int) {
        if (canIGo(number)) {
            forward()
        }
    }

    private fun forward() {
        currentLocation += "-"
    }

    private fun canIGo(number: Int): Boolean {
        return number in 4..9
    }

    fun currentLocation(): String {
        return currentLocation
    }
}
