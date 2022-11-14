package racingcar.domain

enum class Gear(var range: IntRange) {
    FORWARD(4..9),
    STOP(0..3);

    companion object {
        fun getGear(number: Int): Gear {
            return values().find { it.range.contains(number) }!!
        }
    }
}
