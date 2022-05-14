package step3

class Car private constructor(private var carName: String){
    private var position = 0

    val positionList = ArrayList<Int>()

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        positionList.add(position)
    }

    companion object {
        fun makeCar(carName: String): Car{
            return Car(carName)
        }
    }

    fun getPosition() : Int{
        return this.position
    }

    fun getCarName() : String{
        return this.carName
    }
}

