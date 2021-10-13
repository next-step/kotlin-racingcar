# kotlin-racingcar

## 2021/10/12 (화) 강의

### 체크 사항
* 코드 컨벤션 (구글 자바, 앵귤러JS 깃 컨벤션)
* 커밋 주도 개발
* 린트 검사 (`Ktlint` 사용)
  * [코틀린 코딩 컨벤션](https://kotlinlang.org/docs/coding-conventions.html#interface-implementation-layout0)
  * [안드로이드 코틀린 스타일 가이드](https://developer.android.com/kotlin/style-guide)
* 그래이들
  * 빌드 > 체크 > 테스트

### 코틀린 소개

#### 특징
* 자바와 100 퍼센트 호환 되게끔 구현하면 백 퍼센트 호환
* 자바에 비해 간결한 문법
* 정적타입 지정 언어 (타입 추론)
* 함수와 메서드의 차이
* 코틀린(1.5버전 이후부터)에서 메인 함수의 인자는 생략 가능
  * 다만 코틀린 1.3 버전 이하인 경우 `main` 함수는 `Array<String>` 매개 변수를 가져야 함
* 변수 선언 시 `var`, `val`
* `Statement`, `Expression` 차이 숙지
* 메인 클래스에 테스트 작성할 때 문제점
  * 프로덕션 코드와 테스트 코드의 혼재
  * 실서비스에 같이 그대로 (또는 주석처리하여) 배포되는 경우가 많음
  * 테스트 코드를 수동으로 확인해야 함 (인적 장애 유발)
* 학습테스트는 기능적인 동작을 확인하거나 논리적인 로직 확인 등에 활용
* `Junit`
  * 자주 쓰이는 애너테이션
    * `@Test`
    * `@BeforeEach`
    * `@AfterEach`
    * `@BeforeAll`
    * `@AfterAll`
  * `internal` 키워드로 함수 선언 시 함수명이 변경되어 컴파일 됨
    * 자바에는 일치하는 접근제어자가 없어 자바 소스에서 접근하기 어렵게 하기 위한 처리
  * `@BeforeAll`, `@AfterAll` 등은 `companion object` + `@JvmStatic` 조합하여 사용
    * 정적 함수로 선언되어야 하나 코틀린은 `static`이 없음
* 자바 소스를 코틀린 소스로 쉽게 변환 가능
  * `cmd` + `shift` + `a` > `Action` 기능

## Ktlint
설정 방법
* `$ ./gradlew ktlintApplyToIdea` (해당 프로젝트만 적용)
  * `$ ./gradlew ktlintApplyToIdeaGlobally` (모든 IDEA 프로젝트에 적용)
* `$ mkdir .git/hooks`
  * 이미 존재
* `$ ./gradlew addKtlintCheckGitPreCommitHook`

`IDEA` 설정
* `$ ./gradlew ktlintApplyToIdea`

## 미션
자바-코틀린 변환
* 자바 코드를 복사한 후 코틀린 파일에 붙여 넣기
* `Code` > `Convert Java File to Kotlin File`(`⌥⇧⌘K` 또는 `Ctrl+Shift+Alt+K`)을 선택

### `Person` 자바 소스를 코틀린 소스로 변환
~~~Java
public class Person {
    private final String name;
    private final int age;
    private String nickname;

    public Person(final String name, final int age, final String nickname) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }
}
~~~
