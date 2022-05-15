package step3

class Cars private constructor(carNames: String) {
    val carList = ArrayList<Car>()

    init {
        val carNamesArray = carNames.split(",")
        for (i in carNamesArray.indices) {
            carList.add(Car.makeCar(carNamesArray[i]))
        }
    }

    fun run(movingStrategy: MovingStrategy) {
        carList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    fun getWinnerList():List<String> {
        val winnerList = ArrayList<String>()
        var max = 0
        for (j in 0 until carList.size) {
            val position = carList[j].position
            if(position > max) {
                winnerList.clear()
                max = position
                winnerList.add(carList[j].name)
            } else if (position == max && position != 0) {
                winnerList.add(carList[j].name)
            }
        }
        return winnerList
    }
    companion object {
        fun from(carNames: String): Cars {
            return Cars(carNames)
        }
    }
}



