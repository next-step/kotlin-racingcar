package racingcar.domain

class Car(
    private val engine: Engine,
    private val name: String,
    private var position: Int = 0
) {
    init {
        when {
            name.length > 5 -> {
                throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
            }
        }
    }

    fun move() {
        if (engine.getPower() >= FORWARD_POWER_CONDITION) {
            position += FORWARD_DISTANCE
        }
    }

    // 이거 속성에 private 없애지않고 getter 따로 만드는 방법 있나요? car.location으로 가져갈 수 있도록.
    fun getLocation(): Int {
        return position
    }

    fun getName(): String {
        return name
    }

    companion object {
        const val FORWARD_POWER_CONDITION = 4
        const val FORWARD_DISTANCE = 1
    }
}