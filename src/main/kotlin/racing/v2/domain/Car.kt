package racing.v2.domain

class Car {
    var position: Int = 0
        private set

    fun moveForward(policy: DrivingPolicy, number: Int) {
        if (policy.canForward(number)) {
            position++
        }
    }
}
