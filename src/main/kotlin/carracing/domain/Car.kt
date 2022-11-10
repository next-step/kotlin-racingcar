package carracing.domain

const val INIT_POSITION: Int = 1
const val MOVABLE_CONDITION: Int = 4

class Car(var position: Int = INIT_POSITION) {

    fun move(value: Int) {
        if (value >= MOVABLE_CONDITION) position++
    }
}
