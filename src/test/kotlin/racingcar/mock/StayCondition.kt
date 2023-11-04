package racingcar.mock

import racingcar.RandomNumberHolder

class StayCondition: RandomNumberHolder {
    override fun getRandomNumber(): Int {
        return 3
    }
}