package racingcar.domain.car

class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= 5) { "Length of name should be no more than 5" }
    }

    fun move(amount: Int) {
        position += amount
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
