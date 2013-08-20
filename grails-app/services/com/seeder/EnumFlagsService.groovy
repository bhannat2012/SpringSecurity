package com.seeder

import com.enums.ItemTypeEnum

class EnumFlagsService {

    def itemTypes() {
        ItemTypeEnum.saveAll([
                new ItemTypeEnum(enumCode:'FG',enumDescription: 'Finish Goods' ),
                new ItemTypeEnum(enumCode:'RM',enumDescription: 'Raw Materials' ),
                new ItemTypeEnum(enumCode:'SC',enumDescription: 'Scrap' ),
                new ItemTypeEnum(enumCode:'IM',enumDescription: 'Intermediate' )
        ])
    }


}
