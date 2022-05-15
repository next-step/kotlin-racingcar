package racingCar.entity

import racingCar.constants.Messages.INITIAL_MOVES
import racingCar.constants.Messages.MINIMUM_MOVE_FORWARD_NUMBER

// public location 변수 생성
class Car(moves: Int = INITIAL_MOVES) {
    // 바뀔 수 있는 private 변수 생성
    private var privateMoves = moves

    // 외부에 노출되는 값의 getter에 private 변수 값을 리턴하도록 설정
    val moves get() = privateMoves

    // 값을 넣어서 움직이는 함수로 수정
    fun move(rand: Int) {
        if (rand >= MINIMUM_MOVE_FORWARD_NUMBER) this.privateMoves += 1
    }
}
