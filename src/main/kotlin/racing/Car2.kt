package racing

class Car2(val name: String, var _positon: Int) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자 이하로 해주세요." }
    }

    val position
        get() = _positon



    fun move() {
        _positon++
    }
}
