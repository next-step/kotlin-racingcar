package racingcar.domain

object MoveCarAccelerator : CarAccelerator {

    override fun trigger(): CarAction = CarAction.MOVE
}

object StopCarAccelerator : CarAccelerator {

    override fun trigger(): CarAction = CarAction.STOP
}