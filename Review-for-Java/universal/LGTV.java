package universal;

public class LGTV extends UniversalRemote implements Tv{
    private String name;
    private String channel;
    private final int channelNum;

    public LGTV(String name, String channel, int channelNum) {
        this.channelNum = channelNum;
        this.channel = channel;
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public int getChannelNum() {
        return channelNum;
    }


//    메서드 구현
    @Override
    public boolean power() {
        return true;
    }

    @Override
    public void pairing() {
        if(true) {
            System.out.println("현재 UniversalRemote 과 페어링 되어있습니다.");
        } else {
            System.out.println("페어링이 되어있지 않습니다.");
        }
    }

    @Override
    public void checkChannel() {
        System.out.println("채널을 " + channelNum + "번으로 변경합니다.");
    }

    @Override
    public void changeChannel() {
        System.out.println("유튜브를 스트리밍 중입니다.");
    }

    @Override
    public void tvName() {
        System.out.println("Tv의 이름은 " + name + "입니다.");
    }
}
