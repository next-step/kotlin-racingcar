package step3_4.validator

object CarNamesDuplicateValidator {
    fun checkValidate(carNameList: List<String>) {
        require(carNameList.count() == carNameList.toSet().count()) { error(DUPLICATE_ELEMENT_IS_EXIST) }
    }

    private const val DUPLICATE_ELEMENT_IS_EXIST = "중복 요소가 존재 합니다"
}
