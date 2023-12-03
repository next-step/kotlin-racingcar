package racing

class Cars2(private val carList: List<Car2>) {
    fun getWinners(): List<Car2> {
        val maxPosition = carList.maxOfOrNull { it.position }
        return carList.filter { it.position == maxPosition }
    }
}
