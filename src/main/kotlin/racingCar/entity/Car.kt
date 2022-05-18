package racingCar.entity

import racingCar.constants.Messages.INITIAL_MOVES
import racingCar.constants.Messages.MINIMUM_MOVE_FORWARD_NUMBER

// parameter를 받아 내부 값으로 전달하고 private setter를 사용할 수 없게 설정했습니다.
class Car(moves: Int = INITIAL_MOVES) {
    var moves: Int = moves
        private set

    // 값을 넣어서 움직이는 함수로 수정
    fun move(rand: Int) {
        if (rand >= MINIMUM_MOVE_FORWARD_NUMBER) this.moves += 1
    }
}
