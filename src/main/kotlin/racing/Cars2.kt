package racing

class Cars2(private val carList: List<Car2>) {
    fun getWinners(): List<Car2> {
        val maxPosition = carList.maxOfOrNull { it.position }
        return carList.filter { it.position == maxPosition }
    }

    fun moveCars(moveList: List<Boolean>) {
        carList.forEachIndexed { index, car ->
            if (moveList[index]) car.move()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Cars2) return false
        return this.carList == other.carList
    }

    override fun hashCode(): Int {
        return carList.hashCode()
    }
}
