package marumasa.maruma_sign_webui.client;

import marumasa.maruma_sign_webui.ServerManager;
import marumasa.maruma_sign_webui.util.Utils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class MarumaSignWebUIClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // キーバインド登録
        KeyBinding binding = KeyBindingHelper.registerKeyBinding(
                Utils.createKeyBinding("open_menu", GLFW.GLFW_KEY_B)
        );

        // クライアントティックイベントにキーバインドの処理を登録
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            // もしキーが押されたら
            while (binding.wasPressed()) {
                client.player.sendMessage(Text.translatable("chat.maruma_sign_webui.open_menu"), false);
                ServerManager.openMenu();
            }
        });
    }
}
