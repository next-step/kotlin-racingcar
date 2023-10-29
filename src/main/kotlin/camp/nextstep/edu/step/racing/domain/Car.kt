package camp.nextstep.edu.step.racing.domain

data class Car(
    val carName: String = "",
    var position: Int = 0
) {
    init {
        require(carName.isNotBlank()) { "자동차의 이름이 비어있습니다." }
    }

    fun moveForward(isMove: Boolean) {
        if (isMove) {
            this.position += 1
        }
    }

    fun displayCarsNameAndPosition() {
        println("${this.carName} : ${"-".repeat(this.position)}")
    }

}
