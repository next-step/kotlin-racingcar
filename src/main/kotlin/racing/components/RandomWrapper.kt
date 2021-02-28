package racing.components

import kotlin.random.Random

class RandomWrapper() {

    private var isTest: Boolean = false
    private var returnValue: Int? = null

    constructor(isTest: Boolean, returnValue: Int? = null) : this() {
        this.isTest = isTest
        this.returnValue = returnValue
    }

    fun nextInt(until: Int): Int {
        if (isTest) {
            return returnValue ?: until - 1
        }
        return Random.nextInt(until)
    }
}
