package racingcar.domain

class Car(val id: Int, private val driveCondition: DriveCondition) {
    var distance: Int = 1

    fun drive() {
        if (driveCondition.checkDriveCondition()) {
            distance++
        }
    }
}
