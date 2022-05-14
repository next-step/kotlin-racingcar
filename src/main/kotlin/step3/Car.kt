package step3

class Car private constructor(private var carName: String){
    var position = 0
    private set

    val name = carName

    val positionList = ArrayList<Int>()

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        positionList.add(position)
    }

    companion object {
        const val CAR_NAME_NUMBER_FIVE_EXCEED = "자동차 이름은 5자를 초과할 수 없습니다."
        fun makeCar(carName: String): Car{
            if(carName.length > 5) {
                throw IllegalArgumentException(CAR_NAME_NUMBER_FIVE_EXCEED)
            }
            return Car(carName)
        }
    }
}


