package racing

class PlayCarList(val carList: List<Car>) {
    fun getWinners(): List<Car> {
        val maxPosition = carList.maxOfOrNull { it.position }
        return carList.filter { it.position == maxPosition }
    }

    fun moveCars(moveList: List<Boolean>) {
        carList.forEachIndexed { index, car ->
            if (moveList[index]) car.move()
        }
    }

    fun carsSize() = carList.size

    override fun equals(other: Any?): Boolean {
        if (other !is PlayCarList) return false
        return this.carList == other.carList
    }

    override fun hashCode(): Int {
        return this.carList.hashCode()
    }
}
