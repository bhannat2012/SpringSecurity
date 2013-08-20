package com.enums

class EnumFlag {
    String enumCode;
    String enumDescription;
    static constraints = {
        enumCode blank: false ,size: 1..50
        enumDescription  lank: false ,size: 1..200
    }
     String toString(){
         "${enumCode}-${enumDescription}";
     }
}
