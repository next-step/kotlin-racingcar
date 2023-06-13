package step3

class RacingCar {
    var position: Int = 0

    fun tryMove(value: Int) =
        when (value) {
            in 0..4 -> position++
            else -> position
        }

    fun printPosition() {
        for (i in 0 until position) {
            print("-")
        }
        println()
    }
}
