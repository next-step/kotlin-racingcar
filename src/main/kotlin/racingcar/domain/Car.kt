package racingcar.domain

class Car(val id: Int, private val driveCondition: DriveCondition) {
    var distance:Int = 1

    fun drive(number: Int) {
        if (driveCondition.checkDriveCondition(number)) {
            distance++
        }
    }
}