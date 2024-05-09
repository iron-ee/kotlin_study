package main.kotlin.oop.nested_class

/*
일단, 중첩 클래스의 종류로는 대강 크게 2가지로 Static 을 사용하나 안 하나로 구분
- Static 을 사용하는 중첩 클래스          => 밖에 클래스 직접 참조 불가
- Static 을 사용하지 않는 중첩 클래스
    -> 내부 클래스(Inner Class)        => 클래스 안의 클래스, 밖의 클래스 직접 참조 가능
    -> 지역 클래스(Local Class)        => 메소드 내부에 클래스 정의
    -> 익명 클래스(Anonymous Class)    => 일회성 클래스 (직전에 이미 다룸 참고)

1. 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어 참조를 해지하지 못하는 경우 메모리 누수가 발생할 수 있고, 이를 디버깅 하기 어려움.
2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있음.
-> 그래서 왠만하면 클래스 안에 클래스를 만들 때는 static 클래스를 사용 권함. (java guide 참고)
 */

/*
참고용 java
public class JavaHouse {

  private String address;
  private LivingRoom livingRoom;

  public JavaHouse(String address) {
    this.address = address;
    this.livingRoom = new LivingRoom(10);
  }

  public LivingRoom getLivingRoom() {
    return livingRoom;
  }

  public class LivingRoom {     // 해당 클래스가 static 으로 정의한다면 밑에서 바깥 클래스를 바로 불러올 수 없음
    private double area;

    public LivingRoom(double area) {
      this.area = area;
    }

    public String getAddress() {
      return JavaHouse.this.address;        // 바깥 클래스와 연결되어 있음.
                                            // static 일 경우 바깥 클래스 참조 불가
    }
  }
}
 */

// 위 코드와 동일한 kotlin 코드
class House(
    var address: String,
    var livingRoom: LivingRoom = LivingRoom(10.0)
) {

    class LivingRoom(
        private var area: Double,
    )
    // 기본적으로 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어진다.
}

// 권장되지 않는 클래스 안의 클래스
class House2(
    var address: String,
) {
    var livingRoom = this.LivingRoom(10.0)
    inner class LivingRoom(         // 내부 클래스를 작성할 때는 inner 키워드를 넣어줘야 한다.
        private var area: Double,
    ) {
        val address: String
            get() = this@House2.address     // 바깥 클래스를 참조하기 위해 this@바깥클래스명 을 사용한다.
    }
    // 기본적으로 바깥 클래스를 참조하지 않는다.
    // 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가하며, this@바깥클래스명 을 사용한다.
}


/*
kotlin 에서는 이러한 가이드를 따르기 위해
1. 클래스 안에 기본 클래스를 사용하면 바깥 클래스에 대한 참조가 없고
2. 바깥 클래스를 참조하고 싶다면, inner 키워드를 붙여줘야 한다.

코틀린 inner class 에서 바깥 클래스를 참조하려면 this@바깥클래스명 을 사용해야 한다.
 */