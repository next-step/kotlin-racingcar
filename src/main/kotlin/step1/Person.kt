package step1

/**
 * 1. Person.java -> Person.kt
 * ---
 * final -> "val"
 * non-final -> "var"
 * @Nullable String -> String?
 *
 * 2. Nullable
 * 타입 뒤에 '?'를 붙여서 명시적으로 nulllable 타입이라는 것을 알린다.
 * 그렇지 않으면 컴파일 에러 발생
 *
 * 3. Default Parameter
 * 부 생성자로 인자를 2개만 받는 생성자를 사용하는 대신에 파라미터 뒤에 기본 값을 지정이 가능하다.
 *
 * 4. data class
 * equals(), hashCode()를 자동으로 프로퍼티로 비교하는 형태로 만들어 준다.
 * copy 함수를 통해 불변 클래스를 손쉽게 복사가 가능하다.
 */
data class Person(val name: String, val age: Int, val nickname: String? = name)
