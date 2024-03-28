package marumasa.maruma_sign_webui.client;

import marumasa.maruma_sign_webui.ServerManager;
import marumasa.maruma_sign_webui.util.Utils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class MarumaSignWebUIClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // キーバインド登録
        KeyBinding binding = KeyBindingHelper.registerKeyBinding(
                Utils.createKeyBinding("open_menu", GLFW.GLFW_KEY_M)
        );

        // クライアントティックイベントにキーバインドの処理を登録
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // もしキーが押されたら
            while (binding.wasPressed()) {
                ServerManager.openMenu();
            }
        });
    }
}
