package fixture

import racingcar.Car

object CarFixture {
    const val KIM_NAME = "kim"
    const val PACK_NAME = "pack"
    const val LEE_NAME = "lee"

    val KIM_CAR = Car(KIM_NAME)
    private val PACK_CAR = Car(PACK_NAME)
    private val LEE_CAR = Car(LEE_NAME)

    val CAR_NAMES = listOf(KIM_NAME, PACK_NAME, LEE_NAME)
    val CARS = listOf(KIM_CAR, PACK_CAR, LEE_CAR)
}
