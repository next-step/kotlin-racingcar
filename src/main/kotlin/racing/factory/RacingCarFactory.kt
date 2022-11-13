package racing.factory

import racing.domain.RacingCar
import racing.domain.RacingCarId
import java.util.UUID

object RacingCarFactory {
    fun create(): RacingCar {
        val uuid = UUID.randomUUID().toString()
        val racingCarId = RacingCarId(uuid)
        return RacingCar(id = racingCarId)
    }

    fun create(num: Int): List<RacingCar> =
        buildList {
            for (i in 0 until num) {
                this.add(create())
            }
        }
}
