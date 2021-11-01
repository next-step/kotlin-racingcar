package step3.racingcar.domain

data class Car(
    private var position: Position,
    private val engine: Engine
) {
    private val racing = Racing(engine)

    fun race() {
        position = racing.race(position)
    }

    fun race(numberOfRace: Int): Unit = repeat(numberOfRace) {
        race()
    }

    fun currentPosition(): Int = position.value
}
