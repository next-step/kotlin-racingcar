package racing.domain

import racing.PlayCarList
import racing.ResultData

class Racing(val playCarList: PlayCarList, private val carMoveLogic: CarMoveInterface) {

    val result = ResultData()
    fun play(playCnt: Int) {
        repeat(playCnt) {
            val isMoveList = carMoveLogic.isMoveList(playCarList.carsSize())
            playCarList.moveCars(isMoveList)
            result.saveResultData(playCarList)
        }
    }
}
