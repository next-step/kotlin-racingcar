package step4.domain

/**
 *
 * @author Leo
 */
data class CarName(val name: String) {

    init {
        require(this.name.length < 5) {
            "자동차 이름은 5자를 초과할 수 없다."
        }
    }
}
