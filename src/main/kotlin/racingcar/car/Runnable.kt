package racingcar.car

interface Runnable {
    val position: Int

    fun run(): Runnable

    fun move(): Int {
        return position + getDistance()
    }

    fun getDistance(): Int
}