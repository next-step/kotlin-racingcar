package step3

class Car private constructor(){
    private var position = 0

    val positionList = ArrayList<Int>()

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        positionList.add(position)
    }

    companion object {
        fun makeCar(): Car{
            return Car()
        }
    }

    fun getPosition() : Int{
        return this.position
    }
}

