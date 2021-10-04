package kz.chesschicken.rubetaessentials.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widgets.Button;
import org.lwjgl.opengl.GL11;

public class ButtonInventory extends Button {
    public static final String[] commands = new String[] {
            "/ptime reset", //Reset
            "/pweather reset", //Reset
            "/ptime day", //Day
            "/ptime night", //Night
            "/pweather rain", //Rain
            "/pweather clear" //Clean weather
    };

    private final int imageX;
    private final int imageY;

    public ButtonInventory(int id, int x, int y, int i, int j) {
        super(id, x, y, 20, 20, "");
        this.imageX = i;
        this.imageY = j;
    }

    @Override
    public void render(Minecraft minecraft, int mouseX, int mouseY) {
        super.render(minecraft, mouseX, mouseY);
        if (this.visible) {
            GL11.glBindTexture(3553, minecraft.textureManager.getTextureId("/assets/rubetaessentials/textures/gui/buttons.png"));
            this.blit(x, y, imageX, imageY, 20, 20);
        }
    }
}
