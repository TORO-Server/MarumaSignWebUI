package marumasa.maruma_sign_webui.util;

import marumasa.maruma_sign_webui.MarumaSignWebUI;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Utils {
    // キーバインド 作成
    public static KeyBinding createKeyBinding(String name, int code) {
        return new KeyBinding(
                // ID作成
                "key." + MarumaSignWebUI.MOD_ID + "." + name,

                // どのキーか設定
                InputUtil.Type.KEYSYM, code,

                // カテゴリ設定
                "key.categories." + MarumaSignWebUI.MOD_ID
        );
    }
}
