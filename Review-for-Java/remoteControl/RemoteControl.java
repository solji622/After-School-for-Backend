package remoteControl;

public interface RemoteControl {
    // 채널은 000부터 999까지 있음
    void setPower(boolean power); // 전원 온/오프
    void setChannel(int channel); // 특정 채널로 이동
    void nextChannel(); // 다음 채널 이동
    void previousChannel(); // 이전 채널 이동

    void adjustVolume(int level);
}
