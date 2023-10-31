package racing.domain

class CarName(val name: String) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차의 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }

    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CarName

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
