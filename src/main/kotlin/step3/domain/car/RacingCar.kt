package step3.domain.car

import step3.domain.car.distance.CarDistance
import step3.domain.car.distance.DefaultCarDistance
import step3.domain.car.policy.CarNamePolicy
import step3.domain.car.policy.DefaultCarNamePolicy
import java.util.UUID

class RacingCar(
    val name: String = UUID.randomUUID().toString()
) : CarNamePolicy by DefaultCarNamePolicy, CarDistance<Int> by DefaultCarDistance() {

    init {
        require(isValidName(name)) { "name must be a valid name" }
    }

    fun go() {
        println("$this is going")
        increment(1)
    }

    override fun toString(): String = "${this.javaClass.simpleName}(name=$name, distance=$distance)"
}
