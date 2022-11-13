package race

class Car {
    var movementByRounds = mutableListOf<Boolean>()

    fun move(moveMent: Boolean) {
        movementByRounds.add(moveMent)
    }
}
