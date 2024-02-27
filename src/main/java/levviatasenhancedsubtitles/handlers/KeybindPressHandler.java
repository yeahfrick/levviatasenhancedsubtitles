package levviatasenhancedsubtitles.handlers;

import levviatasenhancedsubtitles.ClientOnlyProxy;
import levviatasenhancedsubtitles.gui.SubtitleDragGui;
import levviatasenhancedsubtitles.gui.SubtitleOverlayHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
public class KeybindPressHandler {
    private static final Logger logger = LogManager.getLogger("SubtitleOverlayHandler");
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (ClientOnlyProxy.myKeyBinding.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen(new SubtitleDragGui());
            logger.info("Subtitle GUI opened");
        }
    }
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (ClientOnlyProxy.myKeyBinding.isPressed()) {
                Minecraft.getMinecraft().displayGuiScreen(new SubtitleDragGui());
                logger.info("Subtitle GUI opened");
            }
        }
    }
}