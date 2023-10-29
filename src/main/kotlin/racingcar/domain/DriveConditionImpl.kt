package racingcar.domain

class DriveConditionImpl : DriveCondition {

    override fun checkDriveCondition(): Boolean {
        return (1..10).random() >= IS_DRIVE
    }

    companion object {
        const val IS_DRIVE: Int = 4
    }
}
