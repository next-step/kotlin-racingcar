package racingcar

class Car(name: String) {
    var name = name
        private set

    var position = 0
        private set

    private fun isGo(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun goStop(random: Int) {
        if (isGo(random)) {
            position += 1
        }
    }
}
