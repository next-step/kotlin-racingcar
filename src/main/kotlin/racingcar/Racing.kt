package racingcar

class Racing {
    // 차 등록 ok
    // 횟수.

    private var carCnt = 0
    private var racingCnt = 0
    private val carList = mutableListOf<Car>()

    init {
        inputData()
        createCar()
    }

    private fun inputData() {
        println("자동차 대수는 몇 대인가요?")
        // val inputCarCnt = readLine()!!
        val inputCarCnt = "3"
        println("시도할 횟수는 몇 회인가요?")
        // val inputRacingCnt = readLine()!!
        val inputRacingCnt = "5"

        Validate.validateInputData(inputCarCnt, inputRacingCnt)

        carCnt = inputCarCnt.toInt()
        racingCnt = inputRacingCnt.toInt()
    }

    private fun createCar() {
        CarManager.createCarList(carCnt)
    }

    fun startRacing() {
        for (i in 0 until racingCnt) {
            println("$i 회차")
            moveCar(i)
            println("")
        }
    }

    private fun moveCar(index: Int) {
        val isMoveList = Rule.isMoveList(carCnt)

        for ((i, isMove) in isMoveList.withIndex()) {
            CarManager.moveCar(i, isMove)
            printCarPosition(CarManager.getCarPosition(i))
            println("")
        }
    }

    private fun printCarPosition(position: Int) {
        for (i in 0 until position) {
            print("-")
        }
    }
}
