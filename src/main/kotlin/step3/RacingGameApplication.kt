package step3

import step3.config.RacingGameConfig

class RacingGameApplication {
    companion object {
        fun start() {
            RacingGameConfig().racingGameController().run()
        }
    }
}
