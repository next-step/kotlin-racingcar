package racingcar.domain

import java.util.Random

class DriveConditionImpl : DriveCondition {

    override fun checkDriveCondition(): Boolean {
        var randomNumber = Random()
        return randomNumber.nextInt(10) >= IS_DRIVE
    }

    companion object {
        const val IS_DRIVE: Int = 4
    }
}
