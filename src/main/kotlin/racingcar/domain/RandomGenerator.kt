package racingcar.domain

import racingcar.util.RacingRandomSetting
import kotlin.random.Random

class RandomGenerator(private val setting: RandomSetting = RacingRandomSetting()) {
    val value: Int
        get() = Random.nextInt(setting.from, setting.until)
}
