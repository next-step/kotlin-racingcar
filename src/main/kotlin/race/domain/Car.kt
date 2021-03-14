package race.domain

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotBlank()) { "name is not blank." }
        require(name.length <= 5) { "name's length is lesser than or equals to 5."}
    }

    fun move(condition: Int): Car {
        if (condition !in 0..9) {
            throw IllegalArgumentException("condition is between 0 and 9.")
        }

        if (isMove(condition)) {
            position++
        }

        return this
    }

    private fun isMove(condition: Int) = condition >= MOVE_CONDITION

    companion object {
        const val MOVE_CONDITION = 4
    }
}
