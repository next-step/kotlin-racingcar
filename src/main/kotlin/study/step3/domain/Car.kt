package study.step3.domain

data class Car(
    var position: Int = 0,
) {
    fun move() {
        position += 1
    }

    fun toResponseByCar(): CarResponse {
        return CarResponse(position)
    }
}
