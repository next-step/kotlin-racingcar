package step3.domain.car

class Car(val id: Int, private val carMovePointDecider: CarMovePointDecider) {

    private var position: Int = 0

    fun move() {
        position += carMovePointDecider.getMovePoint()
    }

    fun getCarStatus(): CarStatus = CarStatus(id, position)

    fun getPosition(): Int = position
}
