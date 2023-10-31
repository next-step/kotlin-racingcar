package racing

import racing.car.CarManager

class Racing(private val racingCnt: Int) {

    // 경기 결과 저장. list<list<Int>>
    // 회차[position, position, position...]

    private val racingResultList = mutableListOf<List<Int>>()

    fun startRacing() {
        for (i in 0 until racingCnt) {
            CarManager.moveCar()
            saveRacingResult()
        }
    }

    fun getRacingResultList() = racingResultList

    private fun saveRacingResult() {
        racingResultList.add(CarManager.getCarPositionList())
    }
}
