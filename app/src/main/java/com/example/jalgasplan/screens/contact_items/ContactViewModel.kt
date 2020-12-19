package com.example.jalgasplan.screens.contact_items

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.utils.DataSource
import com.example.jalgasplan.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    var contact: MutableLiveData<ArrayList<Contact>> = MutableLiveData()


    fun contact() {

        var list = ArrayList<Contact>()

        Log.i("jalgas", list.toString())

        for (i in 0..165) {

            if (i == 0) {
                var contact = Contact(
                    0,
                    "KAR1100",
                    "Водник"
                )
                list.add(contact)
            }

            if (i == 1) {
                var contact = Contact(
                    1,
                    "KAR1101",
                    "Кипчак"
                )
                list.add(contact)
            }

            if (i == 2) {
                var contact = Contact(
                    2,
                    "KAR1102",
                    "Махтумкули"
                )
                list.add(contact)
            }
            if (i == 3) {
                var contact = Contact(
                    3,
                    "KAR1103",
                    "Шарбат"
                )
                list.add(contact)
            }
            if (i == 4) {
                var contact = Contact(
                    4,
                    "KAR1104",
                    "Сарибий"
                )
                list.add(contact)
            }


            if (i == 5) {
                var contact = Contact(

                    5,
                    "KAR1105",
                    "Шорахан"
                )
                list.add(contact)


            }
            if (i == 6) {
                var contact = Contact(

                    6,
                    "KAR1106",
                    "Туркманкули"
                )
                list.add(contact)

            }

            if (i == 7) {
                var contact = Contact(

                    7,
                    "KAR1107",
                    "Коммутатор"
                )
                list.add(contact)


            }
            if (i == 8) {
                var contact = Contact(

                    8,
                    "KAR1108",
                    "Агронитехника"
                )
                list.add(contact)

            }

            if (i == 9) {
                var contact = Contact(

                    9,
                    "KAR1109",
                    "Кириккизабат"
                )
                list.add(contact)


            }
            if (i == 10) {
                var contact = Contact(

                    10,
                    "KAR1110",
                    "Мангит кепич завод"
                )
                list.add(contact)

            }

            if (i == 11) {
                var contact = Contact(

                    11,
                    "KAR1111",
                    "ЖдКолледж"
                )
                list.add(contact)

            }

            if (i == 12) {
                var contact = Contact(

                    12,
                    "KAR1112",
                    "Спорткомплекс"
                )
                list.add(contact)


            }
            if (i == 13) {
                var contact = Contact(
                    13,
                    "KAR1113",
                    "Профтех Колледж"
                )
                list.add(contact)
            }
            if (i == 14) {
                var contact = Contact(
                    14,
                    "KAR1114",
                    "Спид центр"
                )
                list.add(contact)
            }
            if (i == 15) {
                var contact = Contact(
                    15,
                    "KAR1115",
                    "Турткуль рут"
                )
                list.add(contact)
            }
            if (i == 16) {
                var contact = Contact(
                    16,
                    "KAR1116",
                    "Шк Ажинияз"
                )
                list.add(contact)
            }
            if (i == 17) {
                var contact = Contact(
                    17,
                    "KAR1117",
                    "Ру-1"
                )
                list.add(contact)
            }

            if (i == 18) {
                var contact = Contact(
                    19,
                    "KAR1119",
                    "Кизилкала"
                )
                list.add(contact)
            }
            if (i == 19) {
                var contact = Contact(
                    20,
                    "KAR1120",
                    "Сельхоз химия"
                )
                list.add(contact)
            }
            if (i == 20) {
                var contact = Contact(
                    21,
                    "KAR1121",
                    "ATS-215"
                )
                list.add(contact)
            }
            if (i == 21) {
                var contact = Contact(
                    22,
                    "KAR1122",
                    "Кунград рут"
                )
                list.add(contact)
            }
            if (i == 22) {
                var contact = Contact(
                    23,
                    "KAR1123",
                    "Ходжейли рут"
                )
                list.add(contact)
            }
            if (i == 23) {
                var contact = Contact(
                    24,
                    "KAR1124",
                    "Беруний рут"
                )
                list.add(contact)
            }
            if (i == 24) {
                var contact = Contact(
                    25,
                    "KAR1125",
                    "Тахиаташ рут"
                )
                list.add(contact)
            }
            if (i == 25) {
                var contact = Contact(
                    26,
                    "KAR1126",
                    "Мангит рут"
                )
                list.add(contact)
            }
            if (i == 26) {
                var contact = Contact(
                    27,
                    "KAR1127",
                    "Бостан рут"
                )
                list.add(contact)
            }
            if (i == 27) {
                var contact = Contact(
                    28,
                    "KAR1128",
                    "Чимбай рут"
                )
                list.add(contact)
            }
            if (i == 28) {
                var contact = Contact(
                    29,
                    "KAR1129",
                    "Акмангит рут"
                )
                list.add(contact)
            }
            if (i == 29) {
                var contact = Contact(
                    30,
                    "KAR1130",
                    "Халкабад рут"
                )
                list.add(contact)
            }
            if (i == 30) {
                var contact = Contact(
                    31,
                    "KAR1131",
                    "Кегейли рут"
                )
                list.add(contact)
            }
            if (i == 31) {
                var contact = Contact(
                    32,
                    "KAR1132",
                    "Караузяк рут"
                )
                list.add(contact)
            }
            if (i == 32) {
                var contact = Contact(
                    33,
                    "KAR1133",
                    "Тахтакупир рут"
                )
                list.add(contact)
            }
            if (i == 33) {
                var contact = Contact(
                    34,
                    "KAR1134",
                    "Мойнак рут"
                )
                list.add(contact)
            }
            if (i == 34) {
                var contact = Contact(
                    35,
                    "KAR1135",
                    "Канликуль рут"
                )
                list.add(contact)
            }
            if (i == 35) {
                var contact = Contact(
                    36,
                    "KAR1136",
                    "Шуманай рут"
                )
                list.add(contact)
            }
            if (i == 36) {
                var contact = Contact(
                    37,
                    "KAR1137",
                    "Карабайли"
                )
                list.add(contact)
            }
            if (i == 37) {
                var contact = Contact(
                    38,
                    "KAR1138",
                    "Назархан"
                )
                list.add(contact)
            }
            if (i == 38) {
                var contact = Contact(
                    39,
                    "KAR1139",
                    "Каратау"
                )
                list.add(contact)
            }
            if (i == 39) {
                var contact = Contact(
                    40,
                    "KAR1140",
                    "Казанкеткен рут"
                )
                list.add(contact)
            }
            if (i == 40) {
                var contact = Contact(
                    41,
                    "KAR1141",
                    "Содовый завод"
                )
                list.add(contact)
            }
            if (i == 41) {
                var contact = Contact(
                    42,
                    "KAR1143",
                    "Сельхозакадемия"
                )
                list.add(contact)
            }
            if (i == 42) {
                var contact = Contact(
                    43,
                    "KAR1144",
                    "Мискен"
                )
                list.add(contact)
            }
            if (i == 43) {
                var contact = Contact(
                    44,
                    "KAR1145",
                    "Сельхозводопровод"
                )
                list.add(contact)
            }
            if (i == 44) {
                var contact = Contact(
                    45,
                    "KAR1146",
                    "Ф/х Беруний"
                )
                list.add(contact)
            }
            if (i == 45) {
                var contact = Contact(
                    46,
                    "KAR1147",
                    "Алтынкуль рус"
                )
                list.add(contact)
            }
            if (i == 46) {
                var contact = Contact(
                    47,
                    "KAR1148",
                    "Ф/х Алтынкуль"
                )
                list.add(contact)
            }
            if (i == 47) {
                var contact = Contact(
                    48,
                    "KAR1149",
                    "Киличбай"
                )
                list.add(contact)
            }
            if (i == 48) {
                var contact = Contact(
                    49,
                    "KAR1150",
                    "Шахаман"
                )
                list.add(contact)
            }
            if (i == 49) {
                var contact = Contact(
                    50,
                    "KAR1151",
                    "Джамбаскала"
                )
                list.add(contact)
            }
            if (i == 50) {
                var contact = Contact(
                    51,
                    "KAR1152",
                    "Катта Гулдирсин"
                )
                list.add(contact)
            }
            if (i == 51) {
                var contact = Contact(
                    52,
                    "KAR1153",
                    "Джумуртау"
                )
                list.add(contact)
            }
            if (i == 52) {
                var contact = Contact(
                    53,
                    "KAR1154",
                    "Школа-25"
                )
                list.add(contact)
            }
            if (i == 53) {
                var contact = Contact(
                    54,
                    "KAR1155",
                    "Саманбай"
                )
                list.add(contact)
            }
            if (i == 54) {
                var contact = Contact(
                    55,
                    "KAR1156",
                    "Новый офис"
                )
                list.add(contact)
            }
            if (i == 55) {
                var contact = Contact(
                    56,
                    "KAR1157",
                    "Урак балга"
                )
                list.add(contact)
            }
            if (i == 56) {
                var contact = Contact(
                    57,
                    "KAR1158",
                    "Косколь"
                )
                list.add(contact)
            }
            if (i == 57) {
                var contact = Contact(
                    58,
                    "KAR1159",
                    "Тахыркуль"
                )
                list.add(contact)
            }
            if (i == 58) {
                var contact = Contact(
                    59,
                    "KAR1160",
                    "Акчолак"
                )
                list.add(contact)
            }
            if (i == 59) {
                var contact = Contact(
                    60,
                    "KAR1161",
                    "Алиауыл"
                )
                list.add(contact)
            }
            if (i == 60) {
                var contact = Contact(
                    61,
                    "KAR1162",
                    "Казахдарья"
                )
                list.add(contact)
            }
            if (i == 61) {
                var contact = Contact(
                    62,
                    "KAR1163",
                    "Тазажол"
                )
                list.add(contact)
            }
            if (i == 62) {
                var contact = Contact(
                    63,
                    "KAR1164",
                    "Тонмойн"
                )
                list.add(contact)
            }
            if (i == 63) {
                var contact = Contact(
                    64,
                    "KAR1165",
                    "Школа кунходжа"
                )
                list.add(contact)
            }

            if (i == 64) {
                var contact = Contact(
                    65,
                    "KAR1166",
                    "Аптека управление"
                )
                list.add(contact)
            }
            if (i == 65) {
                var contact = Contact(
                    66,
                    "KAR1167",
                    "СВП Достлик"
                )
                list.add(contact)
            }
            if (i == 66) {
                var contact = Contact(
                    67,
                    "KAR1168",
                    "Жанакала"
                )
                list.add(contact)
            }
            if (i == 67) {
                var contact = Contact(
                    68,
                    "KAR1169",
                    "Бешкупир"
                )
                list.add(contact)
            }
            if (i == 68) {
                var contact = Contact(
                    69,
                    "KAR1170",
                    "Кенес"
                )
                list.add(contact)
            }
            if (i == 69) {
                var contact = Contact(
                    70,
                    "KAR1171",
                    "Карабуга"
                )
                list.add(contact)
            }
            if (i == 70) {
                var contact = Contact(
                    71,
                    "KAR1172",
                    "ССГ Караузяк"
                )
                list.add(contact)
            }
            if (i == 71) {
                var contact = Contact(
                    72,
                    "KAR1173",
                    "Юлдуз"
                )
                list.add(contact)
            }
            if (i == 72) {
                var contact = Contact(
                    73,
                    "KAR1174",
                    "ЖБИ Lico Roots"
                )
                list.add(contact)
            }
            if (i == 73) {
                var contact = Contact(
                    74,
                    "KAR1175",
                    "Горводопровод"
                )
                list.add(contact)
            }
            if (i == 74) {
                var contact = Contact(
                    75,
                    "KAR1176",
                    "Беруний ЖБИ"
                )
                list.add(contact)
            }
            if (i == 75) {
                var contact = Contact(
                    76,
                    "KAR1177",
                    "Килчинак"
                )
                list.add(contact)
            }
            if (i == 76) {
                var contact = Contact(
                    77,
                    "KAR1178",
                    "Аязкала"
                )
                list.add(contact)
            }
            if (i == 77) {
                var contact = Contact(
                    78,
                    "KAR1179",
                    "Хлоп завод г.Бустон"
                )
                list.add(contact)
            }
            if (i == 78) {
                var contact = Contact(
                    79,
                    "KAR1180",
                    "НИИЗ"
                )
                list.add(contact)
            }
            if (i == 79) {
                var contact = Contact(
                    80,
                    "KAR1181",
                    "Хокимият"
                )
                list.add(contact)
            }
            if (i == 80) {
                var contact = Contact(
                    81,
                    "KAR1182",
                    "Тамирлаш"
                )
                list.add(contact)
            }
            if (i == 81) {
                var contact = Contact(
                    82,
                    "KAR1183",
                    "Шароф Рашидов"
                )
                list.add(contact)
            }
            if (i == 82) {
                var contact = Contact(
                    83,
                    "KAR1184",
                    "Пахтаабад"
                )
                list.add(contact)
            }
            if (i == 83) {
                var contact = Contact(
                    84,
                    "KAR1185",
                    "Агроэкономколледж"
                )
                list.add(contact)
            }
            if (i == 84) {
                var contact = Contact(
                    85,
                    "KAR1186",
                    "Хатеп"
                )
                list.add(contact)
            }
            if (i == 85) {
                var contact = Contact(
                    86,
                    "KAR1187",
                    "Кунград ММТП"
                )
                list.add(contact)
            }
            if (i == 86) {
                var contact = Contact(
                    87,
                    "KAR1188",
                    "Кизмунайым"
                )
                list.add(contact)
            }
            if (i == 87) {
                var contact = Contact(
                    88,
                    "KAR1189",
                    "Равшан"
                )
                list.add(contact)
            }
            if (i == 88) {
                var contact = Contact(
                    89,
                    "KAR1190",
                    "Бестобе"
                )
                list.add(contact)
            }
            if (i == 89) {
                var contact = Contact(
                    90,
                    "KAR1191",
                    "Школа 33"
                )
                list.add(contact)
            }
            if (i == 90) {
                var contact = Contact(
                    91,
                    "KAR1192",
                    "ОФИ Китай"
                )
                list.add(contact)
            }
            if (i == 91) {
                var contact = Contact(
                    92,
                    "KAR1193",
                    "Байтерек"
                )
                list.add(contact)
            }
            if (i == 92) {
                var contact = Contact(
                    93,
                    "KAR1194",
                    "Инфекционная больница"
                )
                list.add(contact)
            }
            if (i == 93) {
                var contact = Contact(
                    94,
                    "KAR1195",
                    "KK Боян"
                )
                list.add(contact)
            }
            if (i == 94) {
                var contact = Contact(
                    95,
                    "KAR1196",
                    "Беруний"
                )
                list.add(contact)
            }
            if (i == 95) {
                var contact = Contact(
                    96,
                    "KAR1197",
                    "ССГ Шимом"
                )
                list.add(contact)
            }
            if (i == 96) {
                var contact = Contact(
                    97,
                    "KAR1198",
                    "Кангшартал"
                )
                list.add(contact)
            }
            if (i == 97) {
                var contact = Contact(
                    98,
                    "KAR1199",
                    "Мангит РТПЦ"
                )
                list.add(contact)
            }
            if (i == 98) {
                var contact = Contact(
                    99,
                    "KAR1200",
                    "Турткуль профтехколледж"
                )
                list.add(contact)
            }
            if (i == 99) {
                var contact = Contact(
                    100, "KAR1201",
                    "Айбек"
                )
                list.add(contact)


            }
            if (i == 100) {
                var contact = Contact(
                    101,
                    "KAR1202",
                    "Турткульское шоссе"
                )
                list.add(contact)
            }
            if (i == 101) {
                var contact = Contact(
                    102,
                    "KAR1203",
                    "Приаралье"
                )
                list.add(contact)
            }
            if (i == 102) {
                var contact = Contact(
                    103,
                    "KAR1204",
                    "Кызкеткен"
                )
                list.add(contact)
            }
            if (i == 103) {
                var contact = Contact(
                    104,
                    "KAR1205",
                    "Каракалпакия"
                )
                list.add(contact)
            }
            if (i == 104) {
                var contact = Contact(
                    105,
                    "KAR1206",
                    "Кунград базар"
                )
                list.add(contact)
            }
            if (i == 105) {
                var contact = Contact(
                    106,
                    "KAR1207",
                    "Турткуль академия лицей"
                )
                list.add(contact)
            }
            if (i == 106) {
                var contact = Contact(
                    107,
                    "KAR1208",
                    "ССГ Дурдиев"
                )
                list.add(contact)
            }
            if (i == 107) {
                var contact = Contact(
                    108,
                    "KAR1209",
                    "Узбекистан"

                )
                list.add(contact)
            }
            if (i == 108) {
                var contact = Contact(
                    109,
                    "KAR1210",
                    "ММТП У.Жуманиязов"
                )
                list.add(contact)
            }
            if (i == 109) {
                var contact = Contact(
                    110,
                    "KAR1211",
                    "СВП Кумбаскан"
                )
                list.add(contact)
            }
            if (i == 110) {
                var contact = Contact(
                    111,
                    "KAR1212",
                    "Жаслык"
                )
                list.add(contact)
            }
            if (i == 111) {
                var contact = Contact(
                    112,
                    "KAR1213",
                    "Б.Каримбердиев"
                )
                list.add(contact)
            }
            if (i == 112) {
                var contact = Contact(
                    113,
                    "KAR1214",
                    "Саранча"
                )
                list.add(contact)
            }
            if (i == 113) {
                var contact = Contact(
                    114,
                    "KAR1215",
                    "Орнек"
                )
                list.add(contact)
            }
            if (i == 114) {
                var contact = Contact(
                    115,
                    "KAR1216",
                    "Еркиндарья"
                )
                list.add(contact)
            }
            if (i == 115) {
                var contact = Contact(
                    116,
                    "KAR1217",
                    "Кардиология"
                )
                list.add(contact)
            }
            if (i == 116) {
                var contact = Contact(
                    117,
                    "KAR1218",
                    "Арбашы"
                )
                list.add(contact)
            }
            if (i == 117) {
                var contact = Contact(
                    118,
                    "KAR1219",
                    "Мироб"
                )
                list.add(contact)
            }
            if (i == 118) {
                var contact = Contact(
                    119,
                    "KAR1220",
                    "ГидроМетеоЦентр"
                )
                list.add(contact)
            }
            if (i == 119) {
                var contact = Contact(
                    120,
                    "KAR1221",
                    "ПРС Елабад"
                )
                list.add(contact)
            }
            if (i == 120) {
                var contact = Contact(
                    121,
                    "KAR1222",
                    "61-Квартал"
                )
                list.add(contact)
            }
            if (i == 121) {
                var contact = Contact(
                    122,
                    "KAR1223",
                    "Караой"
                )
                list.add(contact)
            }
            if (i == 122) {
                var contact = Contact(
                    123,
                    "KAR1224",
                    "Узынколь"
                )
                list.add(contact)
            }
            if (i == 123) {
                var contact = Contact(
                    124,
                    "KAR1225",
                    "Кутанколь"
                )
                list.add(contact)
            }
            if (i == 124) {
                var contact = Contact(
                    125,
                    "KAR1226",
                    "Кырантау"
                )
                list.add(contact)
            }
            if (i == 125) {
                var contact = Contact(
                    126,
                    "KAR1227",
                    "Тазбаз"
                )
                list.add(contact)
            }
            if (i == 126) {
                var contact = Contact(
                    127,
                    "KAR1228",
                    "Мустакиллик"
                )
                list.add(contact)
            }
            if (i == 127) {
                var contact = Contact(
                    128,
                    "KAR1229",
                    "Кенегес"
                )
                list.add(contact)
            }
            if (i == 128) {
                var contact = Contact(
                    129,
                    "KAR1230",
                    "Найман ОФИ"
                )
                list.add(contact)
            }
            if (i == 129) {
                var contact = Contact(
                    130,
                    "KAR1231",
                    "Бустан Олимджон"
                )
                list.add(contact)
            }
            if (i == 130) {
                var contact = Contact(
                    131,
                    "KAR1232",
                    "Махтумкули новый"
                )
                list.add(contact)
            }
            if (i == 131) {
                var contact = Contact(
                    132,
                    "KAR1233",
                    "Сазанчик"
                )
                list.add(contact)
            }
            if (i == 132) {
                var contact = Contact(
                    133,
                    "KAR1234",
                    "Гульзар"
                )
                list.add(contact)
            }
            if (i == 133) {
                var contact = Contact(
                    134,
                    "KAR1235",
                    "Жанабазар"
                )
                list.add(contact)
            }
            if (i == 134) {
                var contact = Contact(
                    135,
                    "KAR1236",
                    "Кум ауыл"
                )
                list.add(contact)
            }
            if (i == 135) {
                var contact = Contact(
                    136,
                    "KAR1237",
                    "Косбулак"
                )
                list.add(contact)
            }
            if (i == 136) {
                var contact = Contact(
                    137, "KAR1238",
                    "Севинч"
                )
                list.add(contact)


            }

            if (i == 137) {
                var conct = Contact(
                    138,
                    "KAR1239",
                    "Тулкин"
                )

            }
            if (i == 138) {
                var contact = Contact(
                    139,
                    "KAR1240",
                    "Ок олтин"
                )
                list.add(contact)
            }
            if (i == 139) {
                var contact = Contact(
                    140,
                    "KAR1241",
                    "Юкори кишлок"
                )
                list.add(contact)
            }
            if (i == 140) {
                var contact = Contact(
                    141,
                    "KAR1242",
                    "Акчакуль"
                )
                list.add(contact)
            }
            if (i == 141) {
                var contact = Contact(
                    142,
                    "KAR1243",
                    "Жайхун"
                )
                list.add(contact)
            }
            if (i == 142) {
                var contact = Contact(
                    143,
                    "KAR1244",
                    "Намуна"
                )
                list.add(contact)
            }

            if (i == 143) {
                var contact = Contact(
                    144,
                    "KAR1245",
                    "Анасай"
                )
                list.add(contact)
            }
            if (i == 144) {
                var contact = Contact(
                    145,
                    "KAR1246",
                    "Бабур"
                )
                list.add(contact)
            }
            if (i == 145) {
                var contact = Contact(
                    146,
                    "KAR1247",
                    "Телеорай"
                )
                list.add(contact)
            }
            if (i == 146) {
                var contact = Contact(
                    147,
                    "KAR1248",
                    "Кутлы макан"
                )
                list.add(contact)
            }
            if (i == 147) {
                var contact = Contact(
                    148,
                    "KAR1249",
                    "Минжарган"
                )
                list.add(contact)
            }
            if (i == 148) {
                var contact = Contact(
                    149,
                    "KAR1250",
                    "Матанат"
                )
                list.add(contact)
            }
            if (i == 149) {
                var contact = Contact(
                    150,
                    "KAR1251",
                    "Тахиаташ МФИ"
                )
                list.add(contact)
            }
            if (i == 150) {
                var contact = Contact(
                    151,
                    "KAR1252",
                    "Косжап"
                )
                list.add(contact)
            }
            if (i == 151) {
                var contact = Contact(
                    152,
                    "KAR1253",
                    "Канлы"
                )
                list.add(contact)
            }
            if (i == 152) {
                var contact = Contact(
                    153,
                    "KAR1254",
                    "МНО"
                )
                list.add(contact)
            }
            if (i == 153) {
                var contact = Contact(
                    154,
                    "KAR1255",
                    "Турткуль теплица"
                )
                list.add(contact)
            }
            if (i == 154) {
                var contact = Contact(
                    155,
                    "KAR1256",
                    "Кушчилик"
                )
                list.add(contact)
            }
            if (i == 155) {
                var contact = Contact(
                    156,
                    "KAR1257",
                    "Тахиаташ ГРЭС"
                )
                list.add(contact)
            }
            if (i == 156) {
                var contact = Contact(
                    157,
                    "KAR1258",
                    "Тахиаташ НДУ"
                )
                list.add(contact)
            }
            if (i == 157) {
                var contact = Contact(
                    158,
                    "KAR1259",
                    "Бархантур"
                )
                list.add(contact)
            }
            if (i == 158) {
                var contact = Contact(
                    159,
                    "KAR1260",
                    "Яккабог"
                )
                list.add(contact)
            }
            if (i == 159) {
                var contact = Contact(
                    160,
                    "KAR1261",
                    "Хаким ата"
                )
                list.add(contact)
            }
            if (i == 160) {
                var contact = Contact(
                    161,
                    "KAR1262",
                    "Шеге"
                )
                list.add(contact)
            }
            if (i == 161) {
                var contact = Contact(
                    162,
                    "KAR1263",
                    "Порлытау"
                )
                list.add(contact)
            }
            if (i == 162) {
                var contact = Contact(
                    163,
                    "KAR1264",
                    "Шагырлык"
                )
                list.add(contact)

            }
            contact.value = list


        }
    }
}



