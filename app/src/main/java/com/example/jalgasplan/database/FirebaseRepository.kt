package com.example.jalgasplan.database

import android.media.midi.MidiOutputPort
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jalgasplan.model.Contact
import com.example.jalgasplan.model.Main_contact_model
import com.example.jalgasplan.model.Model
import com.example.jalgasplan.repository.Repository
import com.example.jalgasplan.utils.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository : Repository {


    private lateinit var database: FirebaseFirestore

    init {
        AUTH = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()
    }


    override suspend fun insert(model: Model, id: String) {
        val document = database.collection(id).document()
        model.idFirebase = document.id
        val set = document.set(model)
        set.addOnSuccessListener { documentReference ->
            Log.d("jalgas", "DocumentSnapshot added with ID: ")
        }
            .addOnFailureListener { e ->
                Log.w("jalgas", "Error adding document", e)
            }


    }


    override suspend fun delete(model: Model, id: String) {
        database.collection(id).document(model.idFirebase)
            .delete()
            .addOnSuccessListener {
                Log.d(
                    "delete",
                    "DocumentSnapshot successfully deleted!${model.idFirebase}"
                )
            }

            .addOnFailureListener { e -> Log.w("delete", "Error deleting document", e) }
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {

        AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess }
            .addOnFailureListener {
                onFail
                AUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                    .addOnSuccessListener { onSuccess }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }

        CURRENT_ID = AUTH.currentUser?.uid.toString()
        //REF_DATABASE = FirebaseDatabase.getInstance().reference
        // .child(CURRENT_ID)
    }

    override fun signOut() {
        AUTH.signOut()
    }

    override suspend fun insertContact(mainContactModel: Main_contact_model, id: String) {
        val document = database.collection(id).document()
        mainContactModel.idContact_firebase = document.id
        val set = document.set(mainContactModel)
        set.addOnSuccessListener { documnetReference ->
            Log.i("jalgas/1", "addMainContact")
        }
            .addOnFailureListener { e ->
                Log.i("jalgas/2", "ошибка addMainContact")


            }
    }

    override suspend fun deleteContact(mainMain_contact_model: Main_contact_model, id: String) {

        database.collection(id).document(mainMain_contact_model.idContact_firebase)

            .delete()
            .addOnSuccessListener {
                Log.i(
                    "jalgas10",
                    "DocumentSnapshot successfully deleted!${mainMain_contact_model.idContact_firebase}"
                )
            }
            .addOnFailureListener { e -> Log.i("jalgas10", "Error deleting document", e) }
    }


    val contactItem: MutableLiveData<MutableList<Contact>> = MutableLiveData()

    override suspend fun contact(list: MutableList<Contact>) {
       // fun createDataSet(): ArrayList<Contact> {
            var list = ArrayList<Contact>()

            list.add(
                Contact(
                    0,
                    "KAR1100",
                    "Водник"
                )
            )
            list.add(
                Contact(
                    1,
                    "KAR1101",
                    "Кипчак"
                )
            )
            list.add(
                Contact(
                    2,
                    "KAR1102",
                    "Махтумкули"
                )
            )
            list.add(
                Contact(
                    3,
                    "KAR1103",
                    "Шарбат"
                )
            )
            list.add(
                Contact(
                    4,
                    "KAR1104",
                    "Сарибий"
                )
            )
            list.add(
                Contact(
                    5,
                    "KAR1105",
                    "Шорахан"
                )
            )
            list.add(
                Contact(
                    6,
                    "KAR1106",
                    "Туркманкули"
                )
            )
            list.add(
                Contact(
                    7,
                    "KAR1107",
                    "Коммутатор"
                )
            )
            list.add(
                Contact(
                    8,
                    "KAR1108",
                    "Агронитехника"
                )
            )
            list.add(
                Contact(
                    9,
                    "KAR1109",
                    "Кириккизабат"
                )
            )
            list.add(
                Contact(
                    10,
                    "KAR1110",
                    "Мангит кепич завод"
                )
            )
            list.add(
                Contact(
                    11,
                    "KAR1111",
                    "ЖдКолледж"
                )
            )
            list.add(
                Contact(
                    12,
                    "KAR1112",
                    "Спорткомплекс"
                )
            )

            list.add(
                Contact(
                    13,
                    "KAR1113",
                    "Профтех Колледж"
                )
            )
            list.add(
                Contact(
                    14,
                    "KAR1114",
                    "Спид центр"
                )
            )
            list.add(
                Contact(
                    15,
                    "KAR1115",
                    "Турткуль рут"
                )
            )
            list.add(
                Contact(
                    16,
                    "KAR1116",
                    "Шк Ажинияз"
                )
            )
            list.add(
                Contact(
                    17,
                    "KAR1117",
                    "Ру-1"
                )
            )

            list.add(
                Contact(
                    19,
                    "KAR1119",
                    "Кизилкала"
                )
            )
            list.add(
                Contact(
                    20,
                    "KAR1120",
                    "Сельхоз химия"
                )
            )
            list.add(
                Contact(
                    21,
                    "KAR1121",
                    "ATS-215"
                )
            )
            list.add(
                Contact(
                    22,
                    "KAR1122",
                    "Кунград рут"
                )
            )
            list.add(
                Contact(
                    23,
                    "KAR1123",
                    "Ходжейли рут"
                )
            )
            list.add(
                Contact(
                    24,
                    "KAR1124",
                    "Беруний рут"
                )
            )
            list.add(
                Contact(
                    25,
                    "KAR1125",
                    "Тахиаташ рут"
                )
            )
            list.add(
                Contact(
                    26,
                    "KAR1126",
                    "Мангит рут"
                )
            )
            list.add(
                Contact(
                    27,
                    "KAR1127",
                    "Бостан рут"
                )
            )
            list.add(
                Contact(
                    28,
                    "KAR1128",
                    "Чимбай рут"
                )
            )
            list.add(
                Contact(
                    29,
                    "KAR1129",
                    "Акмангит рут"
                )
            )
            list.add(
                Contact(
                    30,
                    "KAR1130",
                    "Халкабад рут"
                )
            )
            list.add(
                Contact(
                    31,
                    "KAR1131",
                    "Кегейли рут"
                )
            )
            list.add(
                Contact(
                    32,
                    "KAR1132",
                    "Караузяк рут"
                )
            )
            list.add(
                Contact(
                    21,
                    "KAR1133",
                    "Тахтакупир рут"
                )
            )
            list.add(
                Contact(
                    34,
                    "KAR1134",
                    "Мойнак рут"
                )
            )
            list.add(
                Contact(
                    35,
                    "KAR1135",
                    "Канликуль рут"
                )
            )
            list.add(
                Contact(
                    36,
                    "KAR1136",
                    "Шуманай рут"
                )
            )
            list.add(
                Contact(
                    37,
                    "KAR1137",
                    "Карабайли"
                )
            )
            list.add(
                Contact(
                    38,
                    "KAR1138",
                    "Назархан"
                )
            )
            list.add(
                Contact(
                    39,
                    "KAR1139",
                    "Каратау"
                )
            )
            list.add(
                Contact(
                    40,
                    "KAR1140",
                    "Казанкеткен рут"
                )
            )
            list.add(
                Contact(
                    41,
                    "KAR1141",
                    "Содовый завод"
                )
            )
            list.add(
                Contact(
                    43,
                    "KAR1143",
                    "Сельхозакадемия"
                )
            )
            list.add(
                Contact(
                    44,
                    "KAR1144",
                    "Мискен"
                )
            )
            list.add(
                Contact(
                    45,
                    "KAR1145",
                    "Сельхозводопровод"
                )
            )
            list.add(
                Contact(
                    46,
                    "KAR1146",
                    "Ф/х Беруний"
                )
            )
            list.add(
                Contact(
                    47,
                    "KAR1147",
                    "Алтынкуль рус"
                )
            )
            list.add(
                Contact(
                    48,
                    "KAR1148",
                    "Ф/х Алтынкуль"
                )
            )
            list.add(
                Contact(
                    49,
                    "KAR1149",
                    "Киличбай"
                )
            )
            list.add(
                Contact(
                    50,
                    "KAR1150",
                    "Шахаман"
                )
            )
            list.add(
                Contact(
                    51,
                    "KAR1151",
                    "Джамбаскала"
                )
            )
            list.add(
                Contact(
                    52,
                    "KAR1152",
                    "Катта Гулдирсин"
                )
            )
            list.add(
                Contact(
                    53,
                    "KAR1153",
                    "Джумуртау"
                )
            )
            list.add(
                Contact(
                    54,
                    "KAR1154",
                    "Школа-25"
                )
            )
            list.add(
                Contact(
                    55,
                    "KAR1155",
                    "Саманбай"
                )
            )
            list.add(
                Contact(
                    56,
                    "KAR1156",
                    "Новый офис"
                )
            )
            list.add(
                Contact(
                    57,
                    "KAR1157",
                    "Урак балга"
                )
            )
            list.add(
                Contact(
                    58,
                    "KAR1158",
                    "Косколь"
                )
            )
            list.add(
                Contact(
                    59,
                    "KAR1159",
                    "Тахыркуль"
                )
            )
            list.add(
                Contact(
                    60,
                    "KAR1160",
                    "Акчолак"
                )
            )
            list.add(
                Contact(
                    61,
                    "KAR1161",
                    "Алиауыл"
                )
            )
            list.add(
                Contact(
                    62,
                    "KAR1162",
                    "Казахдарья"
                )
            )
            list.add(
                Contact(
                    63,
                    "KAR1163",
                    "Тазажол"
                )
            )
            list.add(
                Contact(
                    64,
                    "KAR1164",
                    "Тонмойн"
                )
            )
            list.add(
                Contact(
                    65,
                    "KAR1165",
                    "Школа кунходжа"
                )
            )
            list.add(
                Contact(
                    66,
                    "KAR1166",
                    "Аптека управление"
                )
            )
            list.add(
                Contact(
                    67,
                    "KAR1167",
                    "СВП Достлик"
                )
            )
            list.add(
                Contact(
                    68,
                    "KAR1168",
                    "Жанакала"
                )
            )
            list.add(
                Contact(
                    69,
                    "KAR1169",
                    "Бешкупир"
                )
            )

            list.add(
                Contact(
                    70,
                    "KAR1170",
                    "Кенес"
                )
            )
            list.add(
                Contact(
                    71,
                    "KAR1171",
                    "Карабуга"
                )
            )

            list.add(
                Contact(
                    72,
                    "KAR1172",
                    "ССГ Караузяк"
                )
            )
            list.add(
                Contact(
                    73,
                    "KAR1173",
                    "Юлдуз"
                )
            )
            list.add(
                Contact(
                    74,
                    "KAR1174",
                    "ЖБИ Lico Roots"
                )
            )
            list.add(
                Contact(
                    75,
                    "KAR1175",
                    "Горводопровод"
                )
            )
            list.add(
                Contact(
                    76,
                    "KAR1176",
                    "Беруний ЖБИ"
                )
            )
            list.add(
                Contact(
                    77,
                    "KAR1177",
                    "Килчинак"
                )
            )
            list.add(
                Contact(
                    78,
                    "KAR1178",
                    "Аязкала"
                )
            )
            list.add(
                Contact(
                    79,
                    "KAR1179",
                    "Хлоп завод г.Бустон"
                )
            )
            list.add(
                Contact(
                    80,
                    "KAR1180",
                    "НИИЗ"
                )
            )
            list.add(
                Contact(
                    81,
                    "KAR1181",
                    "Хокимият"
                )
            )
            list.add(
                Contact(
                    82,
                    "KAR1182",
                    "Тамирлаш"
                )
            )
            list.add(
                Contact(
                    83,
                    "KAR1183",
                    "Шароф Рашидов"
                )
            )
            list.add(
                Contact(
                    84,
                    "KAR1184",
                    "Пахтаабад"
                )
            )
            list.add(
                Contact(
                    85,
                    "KAR1185",
                    "Агроэкономколледж"
                )
            )
            list.add(
                Contact(
                    86,
                    "KAR1186",
                    "Хатеп"
                )
            )
            list.add(
                Contact(
                    87,
                    "KAR1187",
                    "Кунград ММТП"
                )
            )
            list.add(
                Contact(
                    88,
                    "KAR1188",
                    "Кизмунайым"
                )
            )
            list.add(
                Contact(
                    89,
                    "KAR1189",
                    "Равшан"
                )
            )
            list.add(
                Contact(
                    90,
                    "KAR1190",
                    "Бестобе"
                )
            )
            list.add(
                Contact(
                    91,
                    "KAR1191",
                    "Школа 33"
                )
            )
            list.add(
                Contact(
                    92,
                    "KAR1192",
                    "ОФИ Китай"
                )
            )
            list.add(
                Contact(
                    9,
                    "KAR1193",
                    "Байтерек"
                )
            )
            list.add(
                Contact(
                    94,
                    "KAR1194",
                    "Инфекционная больница"
                )
            )
            list.add(
                Contact(
                    95,
                    "KAR1195",
                    "KK Боян"
                )
            )
            list.add(
                Contact(
                    96,
                    "KAR1196",
                    "Беруний"
                )
            )
            list.add(
                Contact(
                    97,
                    "KAR1197",
                    "ССГ Шимом"
                )
            )
            list.add(
                Contact(
                    98,
                    "KAR1198",
                    "Кангшартал"
                )
            )
            list.add(
                Contact(
                    99,
                    "KAR1199",
                    "Мангит РТПЦ"
                )
            )
            list.add(
                Contact(
                    100,
                    "KAR1200",
                    "Турткуль профтехколледж"
                )
            )
            list.add(
                Contact(
                    101, "KAR1201",
                    "Айбек"
                )
            )
            list.add(
                Contact(
                    102,
                    "KAR1202",
                    "Турткульское шоссе"
                )
            )
            list.add(
                Contact(
                    103,
                    "KAR1203",
                    "Приаралье"
                )
            )
            list.add(
                Contact(
                    104,
                    "KAR1204",
                    "Кызкеткен"
                )
            )
            list.add(
                Contact(
                    105,
                    "KAR1205",
                    "Каракалпакия"
                )
            )
            list.add(
                Contact(
                    106,
                    "KAR1206",
                    "Кунград базар"
                )
            )
            list.add(
                Contact(
                    107,
                    "KAR1207",
                    "Турткуль академия лицей"
                )
            )
            list.add(
                Contact(
                    108,
                    "KAR1208",
                    "ССГ Дурдиев"
                )
            )
            list.add(
                Contact(
                    109,
                    "KAR1209",
                    "Узбекистан"
                )
            )
            list.add(
                Contact(
                    110,
                    "KAR1210",
                    "ММТП У.Жуманиязов"
                )
            )
            list.add(
                Contact(
                    111,
                    "KAR1211",
                    "СВП Кумбаскан"
                )
            )
            list.add(
                Contact(
                    112,
                    "KAR1212",
                    "Жаслык"
                )
            )
            list.add(
                Contact(
                    113,
                    "KAR1213",
                    "Б.Каримбердиев"
                )
            )
            list.add(
                Contact(
                    114,
                    "KAR1214",
                    "Саранча"
                )
            )
            list.add(
                Contact(
                    115,
                    "KAR1215",
                    "Орнек"
                )
            )
            list.add(
                Contact(
                    116,
                    "KAR1216",
                    "Еркиндарья"
                )
            )
            list.add(
                Contact(
                    117,
                    "KAR1217",
                    "Кардиология"
                )
            )
            list.add(
                Contact(
                    118,
                    "KAR1218",
                    "Арбашы"
                )
            )
            list.add(
                Contact(
                    119,
                    "KAR1219",
                    "Мироб"
                )
            )
            list.add(
                Contact(
                    120,
                    "KAR1220",
                    "ГидроМетеоЦентр"
                )
            )
            list.add(
                Contact(
                    121,
                    "KAR1221",
                    "ПРС Елабад"
                )
            )
            list.add(
                Contact(
                    122,
                    "KAR1222",
                    "61-Квартал"
                )
            )
            list.add(
                Contact(
                    123,
                    "KAR1223",
                    "Караой"
                )
            )
            list.add(
                Contact(
                    124,
                    "KAR1224",
                    "Узынколь"
                )
            )
            list.add(
                Contact(
                    125,
                    "KAR1225",
                    "Кутанколь"
                )
            )
            list.add(
                Contact(
                    126,
                    "KAR1226",
                    "Кырантау"
                )
            )
            list.add(
                Contact(
                    127,
                    "KAR1227",
                    "Тазбаз"
                )
            )
            list.add(
                Contact(
                    128,
                    "KAR1228",
                    "Мустакиллик"
                )
            )
            list.add(
                Contact(
                    129,
                    "KAR1229",
                    "Кенегес"
                )
            )
            list.add(
                Contact(
                    130,
                    "KAR1230",
                    "Найман ОФИ"
                )
            )
            list.add(
                Contact(
                    131,
                    "KAR1231",
                    "Бустан Олимджон"
                )
            )
            list.add(
                Contact(
                    132,
                    "KAR1232",
                    "Махтумкули новый"
                )
            )
            list.add(
                Contact(
                    133,
                    "KAR1233",
                    "Сазанчик"
                )
            )
            list.add(
                Contact(
                    134,
                    "KAR1234",
                    "Гульзар"
                )
            )
            list.add(
                Contact(
                    135,
                    "KAR1235",
                    "Жанабазар"
                )
            )
            list.add(
                Contact(
                    136,
                    "KAR1236",
                    "Кум ауыл"
                )
            )
            list.add(
                Contact(
                    137,
                    "KAR1237",
                    "Косбулак"
                )
            )
            list.add(
                Contact(
                    138, "KAR1238",
                    "Севинч"
                )
            )
            list.add(
                Contact(
                    139,
                    "KAR1239",
                    "Тулкин"
                )
            )
            list.add(
                Contact(
                    140,
                    "KAR1240",
                    "Ок олтин"
                )
            )
            list.add(
                Contact(
                    141,
                    "KAR1241",
                    "Юкори кишлок"
                )
            )
            list.add(
                Contact(
                    142,
                    "KAR1242",
                    "Акчакуль"
                )
            )
            list.add(
                Contact(
                    143,
                    "KAR1243",
                    "Жайхун"
                )
            )
            list.add(
                Contact(
                    144,
                    "KAR1244",
                    "Намуна"
                )
            )
            list.add(
                Contact(
                    145,
                    "KAR1245",
                    "Анасай"
                )
            )
            list.add(
                Contact(
                    146,
                    "KAR1246",
                    "Бабур"
                )
            )
            list.add(
                Contact(
                    147,
                    "KAR1247",
                    "Телеорай"
                )
            )
            list.add(
                Contact(
                    148,
                    "KAR1248",
                    "Кутлы макан"
                )
            )
            list.add(
                Contact(
                    149,
                    "KAR1249",
                    "Минжарган"
                )
            )
            list.add(
                Contact(
                    150,
                    "KAR1250",
                    "Матанат"
                )
            )
            list.add(
                Contact(
                    151,
                    "KAR1251",
                    "Тахиаташ МФИ"
                )
            )
            list.add(
                Contact(
                    152,
                    "KAR1252",
                    "Косжап"
                )
            )
            list.add(
                Contact(
                    153,
                    "KAR1253",
                    "Канлы"
                )
            )
            list.add(
                Contact(
                    154,
                    "KAR1254",
                    "МНО"
                )
            )
            list.add(
                Contact(
                    155,
                    "KAR1255",
                    "Турткуль теплица"
                )
            )
            list.add(
                Contact(
                    156,
                    "KAR1256",
                    "Кушчилик"
                )
            )
            list.add(
                Contact(
                    157,
                    "KAR1257",
                    "Тахиаташ ГРЭС"
                )
            )
            list.add(
                Contact(
                    158,
                    "KAR1258",
                    "Тахиаташ НДУ"
                )
            )
            list.add(
                Contact(
                    159,
                    "KAR1259",
                    "Бархантур"
                )
            )
            list.add(
                Contact(
                    160,
                    "KAR1260",
                    "Яккабог"
                )
            )
            list.add(
                Contact(
                    161,
                    "KAR1261",
                    "Хаким ата"
                )
            )
            list.add(
                Contact(
                    162,
                    "KAR1262",
                    "Шеге"
                )
            )
            list.add(
                Contact(
                    163,
                    "KAR1263",
                    "Порлытау"
                )
            )
            list.add(
                Contact(
                    164,
                    "KAR1264",
                    "Шагырлык"
                )
            )
         //   return list
            contactItem.value = list

        }


   // }

}






