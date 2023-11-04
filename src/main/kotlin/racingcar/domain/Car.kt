package racingcar.domain

class Car(private val name: CarName, private val driveCondition: DriveCondition) {
    var distance: Int = 1
        private set

    fun getName(): CarName {
        return name
    }
    fun drive() {
        if (driveCondition.checkDriveCondition()) {
            distance++
        }
    }
}
