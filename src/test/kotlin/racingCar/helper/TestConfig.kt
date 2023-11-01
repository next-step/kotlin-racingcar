package racingCar.helper

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

object TestConfig : AbstractProjectConfig() {
    override val isolationMode: IsolationMode = IsolationMode.InstancePerLeaf
}
