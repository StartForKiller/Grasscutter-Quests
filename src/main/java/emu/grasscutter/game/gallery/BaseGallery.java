package emu.grasscutter.game.gallery;

import emu.grasscutter.data.excels.GalleryData;
import emu.grasscutter.game.world.Scene;
import lombok.Getter;

public class BaseGallery {
    @Getter private final Scene scene;
    @Getter private final GalleryData config;

    public BaseGallery(Scene scene, GalleryData config) {
        this.scene = scene;
        this.config = config;
    }

    public void init() {

    }
}
