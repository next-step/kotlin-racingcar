package racing.v2.domain

class Car(val name: String = "이름없음") {
    var position: Int = 0
        private set

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    constructor(name: String, position: Int) : this(name) {
        this.position = position
    }

    fun moveForward(policy: DrivingPolicy) {
        if (policy.canForward()) {
            position++
        }
    }
}
