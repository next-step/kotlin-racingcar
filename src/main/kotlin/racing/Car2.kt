package racing

class Car2(val name: String, position: Int) {
    init {
        require(name.length <= 5) {"자동차 이름은 5자 이하로 해주세요."}
    }
}
