package au.lyrael.stacywolves.item;

import au.lyrael.stacywolves.utility.LanguageHelper;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;

import java.util.List;

import static au.lyrael.stacywolves.StacyWolves.CREATIVE_TAB;
import static au.lyrael.stacywolves.StacyWolves.MOD_ID;


public class ItemStacyWolves extends Item {
    private boolean showTooltipsAlways = false;

    public ItemStacyWolves() {
        super();
        this.setCreativeTab(CREATIVE_TAB);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s:%s", MOD_ID, unwrapUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s:%s", MOD_ID, unwrapUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(String.format("%s", unwrapUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String unwrapUnlocalizedName(String unlocalizedName) {
        return LanguageHelper.unwrapUnlocalizedName(unlocalizedName);
    }

    /**
     * Used to format tooltips. Grabs tooltip from language registry with the
     * entry 'item.unlocalizedName.tooltip'. Has support for Handlebars-style
     * templating, and line breaking using '\n'.
     *
     * @param toFormat An ImmutableMap that has all the regex keys and values. Regex
     *                 strings are handled on the tooltip by including '{{regexKey}}'
     *                 with your regex key, of course.
     * @param stack    The ItemStack passed from addInformation.
     * @param list     List of description lines passed from addInformation.
     */
    public void formatTooltip(ImmutableMap<String, String> toFormat, ItemStack stack, List list) {
        if (showTooltipsAlways() || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
            LanguageHelper.formatTooltip(this.getUnlocalizedNameInefficiently(stack) + ".tooltip", toFormat, stack, list);
    }

    /**
     * Just a call to formatTooltip(). If you are overriding this function, call
     * formatTooltip() directly and DO NOT call super.addInformation().
     */
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean whatDoesThisEvenDo) {
        this.formatTooltip(null, stack, list);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return LanguageHelper.getLocalization(this.getUnlocalizedNameInefficiently(stack) + ".name");
    }

    protected boolean showTooltipsAlways() {
        return this.showTooltipsAlways;
    }

    protected void showTooltipsAlways(boolean showTooltipAlways) {
        this.showTooltipsAlways = showTooltipAlways;
    }


}
