package com

import com.enums.ItemTypeEnum

class Item {

    String code,name
    ItemTypeEnum itemType
    static constraints = {
        code blank: false ,size: 1..50
        name blank: false ,size: 1..200
        itemType()
    }
}
