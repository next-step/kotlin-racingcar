package racing.v2.domain

class Car(name: String = "이름없음", position: Int = 0) {
    private val carName: CarName = CarName(name)
    val name: String
        get() = carName.name

    var position: Int = position
        private set

    fun moveForward(policy: DrivingPolicy) {
        if (policy.canForward()) {
            position++
        }
    }

    companion object {
        fun ofList(carsStr: String): List<Car> {
            return carsStr.split(",").map { name -> Car(name) }
        }
    }
}
