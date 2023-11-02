package study.racingcar

import racingcar.move.Move

class AlwaysMove : Move {
    override fun isMove(): Boolean {
        return true
    }
}
