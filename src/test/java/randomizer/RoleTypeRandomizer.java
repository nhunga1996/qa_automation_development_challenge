package randomizer;

import Constant.RoleTypeEnum;
import org.jeasy.random.api.Randomizer;

public class RoleTypeRandomizer implements Randomizer<RoleTypeEnum> {
    @Override
    public RoleTypeEnum getRandomValue() {
        return RandomizerSupport.randomEnum(RoleTypeEnum.class);
    }
}
