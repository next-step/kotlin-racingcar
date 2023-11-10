# Mission with Kotlin in Action

Kotlin in Action 을 읽으면서 학습한 내용이 미션에 어떻게 적용됐는지 기록합니다.

## 정적인 멤버 선언하기

매직 넘버를 상수로 정의해야 할 경우가 존재합니다.
코틀린은 클래스 안에 정적인 멤버를 정의할 수 없으며 static 키워드를 지원하지 않습니다.
코틀린에서 정적인 멤버를 선언하는 방법에 대해 배워봅니다.

### 최상위 함수

- 코틀린에서는 패키지 수준의 최상위 함수, 프로퍼티를 사용할 수 있습니다.
- 최상위 함수는 자바의 정적 메서드 역할을 거의 대신할 수 있습니다.
- 최상위 프로퍼티를 활용해 코드에 상수를 추가할 수 있습니다.
    - 최상위 프로퍼티도 다른 모든 프로퍼티처럼 접근자 메서드를 통해 자바 코드에 노출됩니다.
    - 상수답게 사용하려면 const 변경자를 추가하여 public static final 필드로 컴파일 할 수 있습니다.

```kotlin
@file:JvmName("MyFunctions")

package example

var opCount = 0 // getter, setter 함수가 노출된다

const val UNIX_LINE_SEPARATOR = "\n" // public static final 필드로 컴파일된다

fun performOperation() {
    opCount++
}
```

### 동반 객체(Companion Object)

- 정적인 멤버를 선언해야 할 경우, 대부분 최상위 함수를 활용하는 편을 더 권장합니다.
- 하지만, 최상위 함수는 private으로 표시된 클래스 비공개 멤버에 접근할 수 없으므로, 클래스 내부 정보에 접근해야 하는 함수가 필요할 때는 클래스에 중첩된 객체 선언을 활용해야 합니다.

```kotlin
class A {
    private val foo = "foo"

    companion object {
        fun inner(a: A) {
            a.foo // ok...! (private 멤버 접근 가능)
        }
    }
}

fun top(a: A) {
    a.foo // error...! (private 멤버 접근 불가)
}
```

### 무엇을 사용할까...?

| 최상위 함수                                    | 동반 객체                                         |
|-------------------------------------------|-----------------------------------------------|
| 상수를 사용하려면 상수명을 외워야 한다.                    | 클래스에 점(.)을 찍어 상수명에 접근할 수 있다.                  |
| private로 설정하더라도, 같은 파일 내의 클래스에서 사용이 가능하다. | private로 설정할 경우, 같은 파일 내의 다른 클래스에서 사용이 불가능하다. |

## 객체 생성시 값 검증하기

객체 생성시 멤버 변수의 값을 검증해야 할 경우가 있습니다.
코틀린에서 제공하는 객체 생성과 관련된 키워드를 학습하여 요구사항을 달성할 수 있습니다.

### 주생성자(primary constructor)

```kotlin
class User(val nickname: String)
```

- 보통 클래스의 모든 선언은 중괄호({}) 사이에 들어간다. 중괄호가 없고 괄호 사이에 val 선언만 존재할 때, 클래스 이름 뒤에 오는 괄호로 둘러싸인 코드를 **주생성자(primary constructor)**
  라고 부른다.

### init

```kotlin
class User constructor(nickname: String) { // 파라미터가 하나만 있는 주 생성자
    val nickname: String

    init { // 초기화 블록
        this.nickname = _nickname
    }
}
```

- 주생성자를 명시적인 선언으로 풀어내면 위와 같다.
- constructor 키워드는 주 생성자나 부 생성자 정의를 시작할 때 사용된다.
- init 키워드는 초기화 블록을 시작한다. 초기화 블록에는 클래스의 객체가 만들어질 때 실행될 초기화 코드가 들어간다. 주 생성자는 별도의 코드를 포함할 수 없으므로 초기화 블록이 필요하다.

### 간결하게 만들기

```kotlin
class User(_nickname: String) {
    val nickname = _nickname // 프로퍼티를 주생성자의 파라미터로 초기화한다.
}
```

- 주 생성자 앞에 별다른 애노테이션이나 가시성 변경자가 없다면 constructor를 생략해도 된다.
- 프로퍼티를 초기화하는 식, 또는 init 블록을 통해 주 생성자의 파라미터를 참조할 수 있다.

```kotlin
class User(val nickname: String)
```

- 주생성자 파라미터 이름 앞에 val을 추가하는 방식으로 프로퍼티 정의와 초기화를 간략히 쓸 수 있다.

## 싱글턴 객체 생성하기

- object 선언은 싱글턴을 정의하는 방법 중 하나다.
- 클래스와 마찬가지로 객체 선언 안에도 프로퍼티, 메서드, 초기화 블록 등이 들어갈 수 있다.
- 하지만, 생성자는(주생성자와 부생성자 모두) 객체 선언에 쓸 수 없다.
- 일반 클래스 인스턴스와 달리 싱글턴 객체는 객체 선언문이 있는 위치에서 생성자 호출 없이 즉시 만들어진다. 따라서 object 선언에는 생성자 정의가 필요 없다.
- 예를 들어, Comparator를 구현할 때, 각 클래스마다 하나의 객체면 충분하다. 따라서 Comparator 인스턴스를 만드는 방법으로는 object 선언이 가장 좋은 방법이다.

```kotlin
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)    
    }
}
```

- object는 유일한 인스턴스에 대한 정적인 필드가 있는 자바 클래스로 컴파일된다.
- 이때 인스턴스 필드의 이름은 항상 INSTANCE다.
- 자바 코드에서 코틀린 object를 사용하려면 INSTANCE 필드에 접근하면 된다.

```
CaseInsensitiveFileComparator.INSTANCE.compare(file1, file2);
```
