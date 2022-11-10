package race

class Car {
    var movedDistance = mutableListOf<Boolean>()

    fun move(moveMent: Boolean) {
        movedDistance.add(moveMent)
    }
}
