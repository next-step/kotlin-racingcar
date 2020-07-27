import java.lang.IllegalArgumentException

const val POSITION_PRINT_FORMAT = "-"

class Car {
    private var position: Int = 0

    fun accelerate(random: Int): Int {
        if (random < 0) {
            throw IllegalArgumentException("0보다 작은 값은 사용이 불가능합니다. [input : $random]")
        }
        if (random > 9) {
            throw IllegalArgumentException("9보다 큰 값은 사용이 불가능합니다. [input : $random]")
        }
        if (random >= 4) {
            position++
        }
        return position
    }

    fun getPosition(): Int {
        return position
    }
}
