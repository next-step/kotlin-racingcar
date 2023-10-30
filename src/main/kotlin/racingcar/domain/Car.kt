package racingcar.domain

class Car(val name: CarName, private val driveCondition: DriveCondition) {
    var distance: Int = 1
        private set

    fun drive() {
        if (driveCondition.checkDriveCondition()) {
            distance++
        }
    }
}
