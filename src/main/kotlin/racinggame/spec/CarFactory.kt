package racinggame.spec

import racinggame.car.Engine
import racinggame.car.RacingCar

class CarFactory(request: String) {
    private val names: List<String> = parseName(request)

    private fun parseName(names: String): List<String> {
        val list = names.split(",").toList()
        validate(names)
        return list
    }

    private fun validate(names: String) {
        if (names.isBlank()) {
            throw IllegalArgumentException("경주할 자동차 이름이 없습니다.")
        }
    }

    fun toRacingCar(engine: Engine): List<RacingCar> {
        return names.map { RacingCar(it, engine) }
    }
}
