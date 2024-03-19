package cn.itedus.lottery.domain.strategy.model.vo;

/**
 * @author vikingar
 * @time 2024/3/19 20:01
 * @description
 */
public class DrawAwardInfo {

    private String awardId;

    private String awardName;

    public DrawAwardInfo(String awardId, String awardName) {
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getRewardId() {
        return awardId;
    }

    public void setRewardId(String rewardId) {
        this.awardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
