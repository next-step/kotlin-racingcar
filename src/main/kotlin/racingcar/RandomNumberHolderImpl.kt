package racingcar

import java.util.Random

class RandomNumberHolderImpl : RandomNumberHolder {
    override fun getRandomNumber(): Int {
        return Random().nextInt(0, 9)
    }
}
