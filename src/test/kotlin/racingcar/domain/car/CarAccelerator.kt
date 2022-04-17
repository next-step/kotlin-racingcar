package racingcar.domain.car

internal class Ignore : CarAccelerator {
    override fun trigger(): CarAction = CarAction.STOP
}
