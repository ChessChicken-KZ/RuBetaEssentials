package kz.chesschicken.rubetaessentials.utils.gui;

import kz.chesschicken.rubetaessentials.ConfigClass;
import kz.chesschicken.rubetaessentials.InitClass;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.widgets.Button;
import net.minecraft.client.resource.language.I18n;

import java.awt.*;

public class GuiModConfig extends ScreenBase {
    public static class AttachedButton extends Button {
        private final ConfigClass.EnumConfigBooleans current;
        public AttachedButton(int id, int x, int y, ConfigClass.EnumConfigBooleans s) {
            super(id, x, y, 150, 20, I18n.translate("options."+s.getName()) + ": " + s.getValue());
            this.current = s;
        }

        public boolean press() {
            current.setValue(!current.getValue());
            text = I18n.translate("options."+current.getName()) + ": " + current.getValue();
            return current.requiresReconnect();
        }
    }

    private ScreenBase parent = null;
    private boolean showWarning = false;

    public GuiModConfig(ScreenBase s) {
        parent = s;
    }

    public GuiModConfig() {
    }


    @Override
    public void init() {
        this.buttons.clear();

        for(int q = 0; q < ConfigClass.EnumConfigBooleans.values().length; q++)
            this.buttons.add(new AttachedButton(q, this.width / 2 - 155 + q % 2 * 160, this.height / 6 + 24 * (q >> 1), ConfigClass.EnumConfigBooleans.values()[q]));

        this.buttons.add(new Button(200, this.width / 2 - 100, this.height / 6 + 168, "Save & Close"));
    }

    @Override
    protected void buttonClicked(Button button) {
        if(button.active) {
            if(button.id != 200) {
                boolean q = ((AttachedButton) button).press();
                showWarning = showWarning || q;
            }
            else {
                InitClass.CONFIG.saveToFile();
                this.minecraft.openScreen(parent);
            }
        }
    }

    @Override
    public void onClose() {
        InitClass.CONFIG.saveToFile();
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.drawTextWithShadowCentred(this.textManager, "RuBeta Essentials Config", this.width / 2, 20, 16777215);
        if(showWarning && minecraft.level != null && minecraft.level.isClient)
            this.drawTextWithShadowCentred(this.textManager, "PLEASE RECONNECT TO APPLY CHANGES!", this.width / 2, 16, new Color(255, 70, 70).getRGB());

        super.render(mouseX, mouseY, delta);
    }
}
