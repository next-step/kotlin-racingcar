package racingcar.domain

object RandomGearFactory : GearFactory {

    override fun getGear(): Gear {
        return Gear.getGear((0..9).random())
    }
}
