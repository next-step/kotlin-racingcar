package racinggame.domain.player

import racinggame.domain.car.system.RacingCarSystem

class Racer(
    val id: String,
) {

    private var racingCarSystem: RacingCarSystem? = null

    fun connect(racingCarSystem: RacingCarSystem) {
        this.racingCarSystem = racingCarSystem
    }

    fun disconnectRacingCarSystem() {
        racingCarSystem = null
    }

    fun notifyGo() {
        racingCarSystem?.pressAccelerator()
    }
}

fun Racer.toUser(): User {
    return User(
        id = id,
    )
}
