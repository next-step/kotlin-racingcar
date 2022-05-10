package racingCar.model

/**
 * 차량의 데이터를 저장하는 데이터 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class Car {
    var position: Int = INIT_POSITION
        private set
    fun advanceOnce() {
        position++
    }

    companion object {
        private const val INIT_POSITION = 0
    }
}
