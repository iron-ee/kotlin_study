package main.kotlin.access_control

fun isDirectoryPath(path: String): Boolean {    // 파일 최상단에 바로 유틸 함수를 작성하면 편함.
    return path.endsWith("/")
}


class Car(
    val name: String,       // val 이기 때문에 getter 만 생성됨
    var owner: String,      // var 이기 때문에 getter, setter 생성
    _price: Int     // 생성자
) {

    var price = _price      // var 이기 때문에 getter, setter 생성

    // 총 3개의 getter, 2개의 setter 존재
}

class Car2(
    internal val name: String,  // internal getter
    private var owner: String,  // getter, setter 모두 private
    _price: Int
) {
    var price = _price      // getter 는 public
        private set         // setter 는 private
    // 위와 같은 방법으로 getter 나 setter 에만 추가로 가시성을 부여할 수 있다.
}


/*
java 와 kotlin 을 함께 사용할 때 주의할 점
- Internal 은 바이트 코드 상 public 이 된다.
 때문에 java 코드에서는 kotlin 모듈의 internal 코드를 가져올 수 있다.
 ex) 상위 모듈이 java, 하위 모듈이 kotlin 으로 이루어졌다면
  이 하위 모듈에 있는 internal 이라고 감싸진 field 나 함수 등을 상위 모듈의 java 에서는 바로 가져올 수 있다.

- kotlin 의 protected 와 java 의 protected 는 다르다.
 java 는 같은 패키지의 kotlin protected 멤버에 접근할 수 있다.
 ex) java 가 생각하는 protected 랑 코틀린이 생각하는 protected 가 달라서
  java 에서는 같은 패키지 쓰니깐 가져다 쓸게 하고 생각하면서 사용할 수 있음
 */

/*
kotlin 에서 패키지는 namespace 관리용이기 때문에 protected 는 의미가 달라졌다.
kotlin 에서는 default 가 사라지고, 모듈간의 접근을 통제하는 internal 이 새로 생겼다.
생성자에 접근 지시어를 붙일 때는 constructor 를 명시적으로 써주어야 한다.
유틸성 함수를 만들 때는 파일 최상단을 이용하면 편리하다.
프로퍼티의 Custom setter 에 접근 지시어를 붙일 수 있다.
java 에서 kotlin 코드를 사용할 때 internal 과 protected 는 주의해야 한다.
 */