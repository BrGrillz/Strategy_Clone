package com.example.prelimbclone.models


data class Regions(
    val mapOfRegions: Map<Region,Int> =
        mapOf(
            Region(
                "^43$|кировская|" +
                        "^28$|амурская|" +
                        "^10$|карелия|" +
                        "^22$|алтайск|" +
                        "^03$|бурятия|" +
                        "^80$|агинский|бурятский|" +
                        "^75$|забайкальский|" +
                        "^85$|иркутская|ордынский"
            ) to 3,
            Region(
                "^12$|марий|эл" +
                        "^13$|мордовия|" +
                        "^52$|нижегородская|" +
                        "^58$|пензенская|" +
                        "^63$|самарская|" +
                        "^64$|саратовская|" +
                        "^73$|ульяноская|" +
                        "^21$|чувашская|республика|" +
                        "^41$|камчатский|" +
                        "^82$|корякский|" +
                        "^49$|магаданская" +
                        "^25$|приморский|" +
                        "^65$|сахалинск|" +
                        "^14$|саха|" +
                        "якутия|" +
                        "^27$|хабароский|" +
                        "^87$|чукотский|" +
                        "^02$|башкортостан|" +
                        "^81$|коми|пермяцкий|" +
                        "^56$|оренбургская|" +
                        "^59$|пермский|" +
                        "^16$|татарстан|" +
                        "^18$|удмуртская|" +
                        "^29$|архангельская|" +
                        "^35$|вологодская|" +
                        "^39$|калининградская|" +
                        "^11$|коми|" +
                        "^51$|мурманская|" +
                        "^83$|ненецкий|" +
                        "^53$|новгородская|" +
                        "^60$|псковская|" +
                        "^04$|алтай" +
                        "^38$|иркутская|" +
                        "^24$|красноярский|" +
                        "^54$|новосибирская|" +
                        "^55$|омская|" +
                        "^84$|таймырский|" +
                        "^19$|хакасия|" +
                        "^88$|эвенкинский|" +
                        "^45$|курганская|" +
                        "^66$|свердловская|" +
                        "^72$|тюменская|" +
                        "^54$|ханты|мансийский|" +
                        "^74$|челябинская|" +
                        "^32$|брянская|" +
                        "^33$|владимирская",
                "братск|крсноярск"
            ) to 2,
            Region(
                "^52$|кировская|" +
                        "^87$|чукотский|" +
                        "^77$|москва|" +
                        "^50$|московская|" +
                        "^47$|ленинградская|" +
                        "^78$|санкт|петербург|" +
                        "^24$|красноярский|" +
                        "^54$|новосибирская|" +
                        "^86$|ханты|мансийский|" +
                        "^89$|ямало|ненецкий",
                "норильск|ханты|мансийск|сургут"
            ) to 1
    )
)
