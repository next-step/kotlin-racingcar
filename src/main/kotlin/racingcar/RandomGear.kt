package racingcar

import racingcar.domain.Gear

object RandomGear {
    fun getGear() = Gear.getGear((0..9).random())
}
