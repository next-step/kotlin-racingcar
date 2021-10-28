package racingcar.engine

import racingcar.constant.Constant

class GoEngine : Engine {
    override fun forward(distance: String): String {
        return distance.plus(Constant.ONE_SPACE)
    }
}
