package racingcar.domain

class DriveConditionImpl : DriveCondition {

    override fun checkDriveCondition(): Boolean {
        return (START_NUMBER..END_NUMBER).random() >= IS_DRIVE
    }

    companion object {
        const val IS_DRIVE: Int = 4
        const val START_NUMBER: Int = 1
        const val END_NUMBER: Int = 10
    }
}
