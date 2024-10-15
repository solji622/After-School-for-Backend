package remoteControl;

public class UniversalRemote implements RemoteControl{
    private TV pairedTV;

    // TV와 리모컨 페어링하는 메서드
    public void pairWith(TV tv) {
        // 이미 다른 TV와 페어링 되어 있을 경우
        if (pairedTV != null && pairedTV != tv) {
            System.out.println(pairedTV.getTVName() + "'s pairing has been disconnected.");
            pairedTV.setPair(false);
        }

        pairedTV = tv;
        tv.setPair(true);
    }

    @Override
    public void setPower(boolean power) {
        // 페어링된 TV가 있고, 그 TV가 페어링 된 상태일 때만 전원 설정 가능
        if (pairedTV != null && pairedTV.isPaired()) {
            pairedTV.setPower(power);
        } else {
            System.out.println("No TV is paired.");
        }

    }

    @Override
    public void setChannel(int channel) {
        // 페어링된 TV가 있고, TV의 전원이 켜져있을 때만 채널 변경 가능
        if (pairedTV != null && pairedTV.isPaired() && pairedTV.isPowerOn()) {
            pairedTV.changeChannel(channel);
        } else if (pairedTV == null || !pairedTV.isPaired()) {
            System.out.println("No TV is paired.");
        } else {
            System.out.println("The TV is OFF. Cannot change channel.");
        }
    }

    @Override
    public void nextChannel() {
        // 페어링된 TV가 있고, TV의 전원이 켜져있을 때만 채널 이동 가능
        if (pairedTV != null && pairedTV.isPaired() && pairedTV.isPowerOn()) {
            previousChannel();
        } else if (pairedTV == null || !pairedTV.isPaired()) {
            System.out.println("No TV is paired.");
        } else {
            System.out.println("The TV is OFF. Cannot next channel.");
        }
    }

    @Override
    public void previousChannel() {

    }
}
