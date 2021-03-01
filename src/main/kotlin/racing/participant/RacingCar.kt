package racing.participant

import racing.result.RacingHistory

class RacingCar(
    name: String,
    private val engine: Engine
) {
    private val racer = Racer(name)

    fun run(): RacingHistory {
        if (engine.enoughEnergy()) {
            racer.move()
        }

        return RacingHistory(
            name = racer.name,
            position = racer.position
        )
    }
}

private class Racer(
    val name: String
) {
    var position: Int = 0
        private set

    fun move() {
        this.position++
    }
}