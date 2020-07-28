package racingcar

class Car(private val num: Int) {
    private var move = 0

    private fun isGo(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun goStop(random: Int) {
        if (isGo(random)) {
            move += 1
        }
    }

    fun getMove(): Int = move

    fun getNum(): Int = num
}
