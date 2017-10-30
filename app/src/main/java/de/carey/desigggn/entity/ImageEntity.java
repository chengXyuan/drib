package de.carey.desigggn.entity;

import java.io.Serializable;

public class ImageEntity implements Serializable {

    /**
     * hidpi : https://cdn.dribbble.com/users/30252/screenshots/3889660/dribbble-room-offset7.gif
     * normal : https://cdn.dribbble.com/users/30252/screenshots/3889660/dribbble-room-offset7_1x.gif
     * teaser : https://cdn.dribbble.com/users/30252/screenshots/3889660/dribbble-room-offset7_teaser.gif
     */

    private String hidpi;
    private String normal;
    private String teaser;

    public String getHidpi() {
        return hidpi;
    }

    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}
