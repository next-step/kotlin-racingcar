package racing

data class Car(var distance: Int = 0, val moveStrategy: MoveStrategy, val name: Name) : Comparable<Car> {
    fun move() {
        if (moveStrategy.isMovable()) {
            distance += 1
        }
    }

    override fun compareTo(other: Car): Int {
        return this.distance.compareTo(other.distance)
    }
}
