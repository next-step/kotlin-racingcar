package camp.nextstep.edu.model

import kotlin.random.Random

data class Car(val name: String, var position: Int = 0) {
    init {
        require(isValidName(name)) { "[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다." }
    }

    private fun isValidName(name: String): Boolean = name.isNotBlank() && name.length <= 5
    private fun canMove(): Boolean = Random.nextInt(0, 10) >= 4

    fun move() {
        if (canMove()) position++

    }
    fun displayPosition() = "$name : ${"-".repeat(position) + "-".repeat(position)}"
    fun isAt(position: Int): Boolean = this.position == position

}