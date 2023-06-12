package racingcar.util

import racingcar.domain.RandomSetting

class RacingRandomSetting : RandomSetting {
    override val from: Int
        get() = 0

    override val until: Int
        get() = 10
}
