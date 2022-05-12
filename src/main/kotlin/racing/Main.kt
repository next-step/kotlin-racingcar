package racing

import racing.domain.CarRacing
import racing.ui.RacingInputReceiver

fun main() {
    CarRacing().run(RacingInputReceiver.receive())
}
