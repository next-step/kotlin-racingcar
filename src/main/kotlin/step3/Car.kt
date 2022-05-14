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
            if(carName.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
            }
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

