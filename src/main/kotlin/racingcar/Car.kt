package racingcar

class Car(
    val name: String,
    var status: Int = 0,
    private var result: String = "",
) {
    init {
        if (name.length > NAME_LENGTH_CONDITION)
            throw IllegalArgumentException("자동자 이름은 ${NAME_LENGTH_CONDITION}자를 넘을 수 없습니다.")
    }

    fun move(condition: Int) {
        if (condition >= MOVE_CONDITION) {
            status++
        }
    }

    fun makeResult(): String {
        val str: StringBuilder = StringBuilder()
        str.append(this.name + " : ")
        for (i in 1..this.status) {
            str.append("-")
        }
        str.append("\n")
        return str.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        return status
    }

    override fun toString(): String {
        return "$name"
    }

    companion object {
        const val MOVE_CONDITION = 4
        const val NAME_LENGTH_CONDITION = 5
    }
}
