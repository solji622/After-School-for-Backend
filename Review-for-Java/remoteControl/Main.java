package remoteControl;

public class Main {
    public static void main(String[] args) {
        TV samsungTV = new SamsungTV();
        TV LGTV = new LGTV();
        TV AppleTV = new AppleTV();
        UniversalRemote remote = new UniversalRemote();

        // 삼성 TV와 페어링
        remote.pairWith(samsungTV);
        remote.setPower(true); // 전원 키기
        remote.setChannel(5); // 5번 채널 변경
        remote.adjustVolume(6); // 볼륨 6으로 설정
        remote.watchSteaming();
        remote.setPower(false);

        System.out.println("============================");

        // LG TV 와 페어링
        remote.pairWith(LGTV);
        remote.setPower(true); // 전원 키기
        remote.setChannel(7); // 7번 채널 변경
        remote.adjustVolume(8); // 볼륨 8로 설정
        remote.watchSteaming();
        remote.setPower(false);

        System.out.println("============================");

        // Apple TV와 페어링
        remote.pairWith(AppleTV);
        remote.setPower(true); // 전원 키기
        remote.setChannel(10); // 10번 채널 변경
        remote.adjustVolume(9); // 볼륨 9로 설정
        remote.watchSteaming();
        remote.setPower(false);
    }
}
