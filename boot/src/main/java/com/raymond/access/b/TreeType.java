package com.raymond.access.b;

import com.raymond.access.a.Maple;

/**
 * Created by Raymond Kwong on 7/4/2018.
 */
class TreeType extends Maple{

    public void test() {
        Maple maple = new Maple();
        String abc = maple.getColor();
        //maple.setColor("S"); protected
        //maple.blur(); private

        TreeType type = new TreeType();
        type.getColor();
        type.setColor("S");
        //type.blur(); private
    }
}
