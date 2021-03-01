package racing.participant

import racing.result.RacingHistory

class RacingCar(
    private val racer: Racer,
    private val engine: Engine
) {

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
