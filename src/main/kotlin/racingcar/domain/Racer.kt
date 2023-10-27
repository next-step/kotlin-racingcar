package racingcar.domain

class Racer(
    val count: Int = 0
) {
    fun run(num: Int): Racer {
        if (num >= 4) {
            return Racer(count + 1)
        }
        return Racer(count)
    }
}
