package marumasa.maruma_sign_webui;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class MarumaSignWebUI implements ModInitializer {
    // ModのID
    public static final String MOD_ID = "maruma_sign_webui";
    // ロガー
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Start: " + MOD_ID);
    }
}
