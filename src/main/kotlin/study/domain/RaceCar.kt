package study.domain

class RaceCar(val name: String, position: Int = 0) {
    init {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    var position: Int = position
        private set

    fun move() {
        position++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RaceCar

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }
}
