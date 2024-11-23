package carracing.domain

import carracing.dto.CarDTO

class Car(
    val name: String,
    private val threshold: Threshold,
    position: Int = 0,
) {
    init {
        require(name.length in 1..5) {
            "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }
    }

    var position = position
        private set

    fun move(value: Int) {
        if (threshold.isSatisfied(value)) {
            position++
        }
    }

    fun toDTO(): CarDTO {
        return CarDTO(name, position)
    }
}
