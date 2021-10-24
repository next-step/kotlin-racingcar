package racingcar.car

import racingcar.engine.CarEngine

class Car(private var name: String = "", private var position: Int = 0, private var carEngine: CarEngine) {

    fun movePosition() {
        if (carEngine.execute()) {
            position++
        }
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Car

        if(name != other.name) return false
        if (position != other.position) return false
        if(carEngine != other.carEngine) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode() + carEngine.hashCode()
        result = 31 * result + position
        return result
    }

    fun getName() = name

    fun getPosition() = position
}
