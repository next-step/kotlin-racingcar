package raicing.model

data class Car(val id: Int) {
    var position: Int = INIT_POSITION
        private set

    fun moveForwardDependingOption(randomNum: Int) {
        if (moveForwardOptionCheck(randomNum))
            position++
    }

    fun deepCopy(): Car {
        val newCar = Car(id)
        newCar.position = position
        return newCar
    }

    private fun moveForwardOptionCheck(randomNum: Int): Boolean {
        return (randomNum >= BASE_NUM)
    }

    companion object {
        const val BASE_NUM = 4
        const val INIT_POSITION = 0
    }
}
