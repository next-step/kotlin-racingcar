package study.racinggame.domain

class Car (
    private val participant: Participant,
    private val engine: CarEngine,
    private var position: Position
) {

    fun move(): CarPosition {
        val moveAmount = engine.run()
        this.position = Position(position.value + moveAmount)
        return CarPosition(participant, position)
    }
}

data class CarPosition(val participant: Participant, val position: Position)
