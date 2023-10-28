package step3_4.validator

object CarNameValidator {
    fun checkValidate(carNameList: List<String>) {
        carNameList.forEach { require(it.length <= CAR_NAME_MAXIMUM_LENGTH) { CAR_NAME_CAN_NOT_EXCEED_MAXIMUM_LENGTH } }
    }

    private const val CAR_NAME_MAXIMUM_LENGTH = 5
    private const val CAR_NAME_CAN_NOT_EXCEED_MAXIMUM_LENGTH = "이름을 5자 이상 초과할 수 없어요."
}
