package remoteControl;

public class LGTV implements TV {
    private int currentChannel = 1;
    private boolean powerOn = false;
    private boolean paired = false;


    @Override
    public void setPower(boolean power) {
        // 리모컨과 페어링된 경우에만 전원을 켜거나 끌 수 있음
        if (paired) {
            powerOn = power;
            if (power) {
                System.out.println("LG TV is now ON.");
            } else {
                System.out.println("LG TV is now OFF.");
            }
        } else {
            System.out.println("LG TV is not paired.");
        }
    }

    @Override
    public void changeChannel(int channel) {
        // 리모컨과 페어링되고, TV의 전원이 켜져 있는 상태에만 채널 변경 가능
        if (paired && powerOn) {
            this.currentChannel = channel;
            System.out.println("LG TV: Channel to channel " + channel);
        } else if (!paired) {
            System.out.println("LG TV is not paired.");
        } else {
            System.out.println("LG TV is OFF. Cannot change channel.");
        }
    }

    @Override
    public int getCurrentChannel() {
        return currentChannel;
    }

    @Override
    public boolean isPowerOn() {
        return powerOn;
    }

    @Override
    public boolean isPaired() {
        return paired;
    }

    @Override
    public void setPair(boolean pair) {
        paired = pair;
        if (pair){
            System.out.println("LG TV paired with remote.");
        } else {
            System.out.println("LG TV unpaired from remote.");
        }
    }

    @Override
    public String getTVName() {
        return "LG TV";
    }



    // 고유 기능 : 유튜브 스트리밍 가능
    public void watchYoutube() {
        // TV의 전원이 켜져 있을 때만 유튜브 시청 가능
        if (powerOn) {
            System.out.println("LG TV : Now streaming Yodtube.");
        } else {
            System.out.println("LG TV is OFF. Cannot stream Yodtube.");
        }
    }
}
