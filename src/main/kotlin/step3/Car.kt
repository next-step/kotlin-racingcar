package step3

class Car {
    var position = 0
        private set

    var positionList = ArrayList<Int>()
        private set

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        positionList.add(position)
    }

    companion object {
        fun getInstance(): Car{
            return Car()
        }
    }
}
