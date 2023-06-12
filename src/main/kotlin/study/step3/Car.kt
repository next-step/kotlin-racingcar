package study.step3

class Car {
    private var state: Int = 1

    fun move() {
        state += 1
    }

    fun getState(): Int {
        return state
    }
}
