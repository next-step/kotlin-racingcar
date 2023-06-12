package study.racinggame.domain

class Car (
    private val participant: Participant,
    private val engine: CarEngine,
    private var position: Position
) {

    fun move(): CarPosition {
        this.position = position.move(engine.run())
        return CarPosition(participant, position)
    }
}
data class CarPosition(val participant: Participant, val position: Position)
