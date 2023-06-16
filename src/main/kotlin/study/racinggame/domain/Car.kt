package study.racinggame.domain

class Car(
    private val participant: Participant,
    private val engine: CarEngine,
    private var position: Position
) {

    fun move(): CarPosition {
        if (engine.run()) {
            this.position = this.position.next()
        }
        return CarPosition(participant, position)
    }
}

data class CarPosition(val participant: Participant, val position: Position) : Comparable<CarPosition> {

    fun isEqualPosition(other: CarPosition): Boolean {
        return position == other.position
    }

    override fun compareTo(other: CarPosition): Int {
        return position.compareTo(other.position)
    }
}
