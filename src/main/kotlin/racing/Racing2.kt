package racing

class Racing2(val cars: Cars2, private val carMoveLogic: CarMoveInterface) {
    fun play(playCnt: Int) {
        repeat(playCnt) {
            val isMoveList = carMoveLogic.isMoveList(cars.carsSize())
            cars.moveCars(isMoveList)
        }
    }
}
