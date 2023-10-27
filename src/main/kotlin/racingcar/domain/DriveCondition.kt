package racingcar.domain

fun interface DriveCondition {
    fun checkDriveCondition(number: Int): Boolean
}