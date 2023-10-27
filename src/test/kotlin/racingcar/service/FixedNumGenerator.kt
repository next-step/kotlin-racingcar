package racingcar.service

import racingcar.util.NumGenerator

class FixedNumGenerator : NumGenerator {
    override fun getNextInt(bound: Int): Int {
        return 4
    }
}
