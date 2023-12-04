package racing

data class Car(val name: String, private var _position: Int = 0) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자 이하로 해주세요." }
    }

    val position
        get() = _position

    fun move() {
        _position++
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Car) return false

        return this.name == other.name && this._position == other._position
    }

    override fun hashCode(): Int {
        return name.hashCode() + _position
    }
}
