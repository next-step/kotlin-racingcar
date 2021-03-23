package car.view.input

class CarNamesInput(names: String?) {
    val names: String

    init {
        require(!names.isNullOrBlank()) { "이름은 공백이면 안됩니다." }
        this.names = names
    }
}
