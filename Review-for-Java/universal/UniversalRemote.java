package universal;

public class UniversalRemote implements Remote{
    public static void main(String[] args) {
        UniversalRemote urSS = new SamsungTv("Samsung Tv", "넷플릭스", 5);
        UniversalRemote urLG = new LGTV("LG TV", "유튜브", 10);

        UniversalRemote remote = urSS;

        if (remote == urSS) {

        }

    }

//    메서드 구현
    @Override
    public boolean power() {
        return true;
    }


    @Override
    public void setChannel() {

    }

    @Override
    public void changeChannel() {
    }
}
