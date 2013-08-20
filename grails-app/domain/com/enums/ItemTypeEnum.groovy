package com.enums

import com.constants.EnumDiscriminators

class ItemTypeEnum extends EnumFlag {

    static constraints = {

    }
    static mapping = {
        discriminator EnumDiscriminators.ITEM_TYPE
    }

   /* String toString(){
        "${enumCode}-${enumDescription}";
    }*/
}
