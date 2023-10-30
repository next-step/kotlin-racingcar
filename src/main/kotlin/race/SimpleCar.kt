package race

import java.lang.IllegalArgumentException

class SimpleCar(val name: String) {
    private var location = ""

    init {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }

    fun getCurrentlocation() = location

    fun move() {
        if ((0..9).random() > 3) location += "-"
    }
}
