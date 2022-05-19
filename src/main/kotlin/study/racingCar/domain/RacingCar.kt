package study.racingCar.domain

class RacingCar {
    lateinit var moveRecordList: List<MutableList<Int>>
    //List => 그냥 kotlin에서 제공하는 api이름인거 같다. records는 어떨까요? cars는 어떨까요?
    // grep.app 에 변수명 검색해보자
    fun raceStart(carNum: Int, roundNum: Int) {

        val carList = List(carNum) {}.map { Car() }
        moveRecordList = List(roundNum) {}.map { List(carNum) {}.map { 0 }.toMutableList() }

        for (i in 0 until roundNum) {
            for (j in 0 until carNum) {
                carList[j].moveOneStep()
                moveRecordList[i][j] = carList[j].movedNum
            }
        }
    }
}
