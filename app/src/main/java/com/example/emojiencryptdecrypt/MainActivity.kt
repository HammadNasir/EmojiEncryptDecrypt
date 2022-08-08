package com.example.emojiencryptdecrypt

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class MainActivity : AppCompatActivity() {

//    var keyGenerator: KeyGenerator? = null
//    var secretKey: SecretKey? = null

//    var IV = ByteArray(16)
//    var random: SecureRandom? = null

    lateinit var txtEncrypted: TextView
    lateinit var txtDecrypted: TextView

    var enc: String? = null

    val emojis = arrayOf("🍎", "🍌", "🏎", "🚪", "👁", "👣", "😀", "🖐", "ℹ", "😂", "🥋", "✉", "🚹", "🌉", "👌", "🍍", "👑", "👉", "🎤", "🚰", "☂", "🐍", "💧", "✖", "☀", "🦓", "🏹", "🎈", "😎", "🎅", "🐘", "🌿", "🌏", "🌪", "☃", "🍵", "🍴", "🚨", "📮", "🕹", "📂", "🛩", "⌨", "🔄", "🔬", "🐅", "🙃", "🐎", "🌊", "🚫", "❓", "⏩", "😁", "😆", "💵", "🤣", "☺", "😊", "😇", "😡", "🎃", "😍", "✅", "🔪", "🗒")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("emojisnum", emojis.size.toString())

        val text = findViewById<EditText>(R.id.etTextEncrypt)
        val btnEncrypt = findViewById<Button>(R.id.btnEncrypt)
        txtEncrypted = findViewById(R.id.txtEncrypted)
        val btnDecrypt = findViewById<Button>(R.id.btnDecrypt)
        txtDecrypted = findViewById(R.id.txtDecrypted)

//        random = SecureRandom()
//        random!!.nextBytes(IV)

//        try {
//            keyGenerator = KeyGenerator.getInstance("AES")
//            keyGenerator?.init(256)
//            secretKey = keyGenerator?.generateKey()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }

        btnEncrypt.setOnClickListener {
//            encrypt = encrypt(text.text.toString().toByteArray(),secretKey!!,IV)
            enc = Base64.getEncoder().encodeToString(text.text.toString().toByteArray())
//            val encryptedText: String? = replaceBase64Chars(enc)
//            txtEncrypted.text = encryptedText
//            Log.d("encodereturn", enc.toString())
            emojify(enc)
        }

        btnDecrypt.setOnClickListener {
//            val decrypt: String? = decrypt(encrypt, secretKey!!, IV)
            unemojify(enc)
        }

    }

//    @Throws(java.lang.Exception::class)
//    fun encrypt(
//        plaintext: ByteArray?,
//        key: SecretKey,
//        IV: ByteArray?
//    ): ByteArray? {
//        val cipher: Cipher = Cipher.getInstance("AES")
//        val keySpec = SecretKeySpec(key.encoded, "AES")
//        val ivSpec = IvParameterSpec(IV)
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
//        return cipher.doFinal(plaintext)
//    }

//    fun decrypt(cipherText: ByteArray?, key: SecretKey, IV: ByteArray?): String? {
//        try {
//            val cipher = Cipher.getInstance("AES")
//            val keySpec = SecretKeySpec(key.encoded, "AES")
//            val ivSpec = IvParameterSpec(IV)
//            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
//            val decryptedText = cipher.doFinal(cipherText)
//            return String(decryptedText)
//        } catch (e: java.lang.Exception) {
//            e.printStackTrace()
//        }
//        return null
//    }

    fun emojify(encod: String?) {
        /* Substitute a - z Base64 characters with emojis. */
        var emojified = encod?.replace("a", emojis[0])
        emojified = emojified?.replace("b", emojis[1])
        emojified = emojified?.replace("c", emojis[2])
        emojified = emojified?.replace("d", emojis[3])
        emojified = emojified?.replace("e", emojis[4])
        emojified = emojified?.replace("f", emojis[5])
        emojified = emojified?.replace("g", emojis[6])
        emojified = emojified?.replace("h", emojis[7])
        emojified = emojified?.replace("i", emojis[8])
        emojified = emojified?.replace("j", emojis[9])
        emojified = emojified?.replace("k", emojis[10])
        emojified = emojified?.replace("l", emojis[11])
        emojified = emojified?.replace("m", emojis[12])
        emojified = emojified?.replace("n", emojis[13])
        emojified = emojified?.replace("o", emojis[14])
        emojified = emojified?.replace("p", emojis[15])
        emojified = emojified?.replace("q", emojis[16])
        emojified = emojified?.replace("r", emojis[17])
        emojified = emojified?.replace("s", emojis[18])
        emojified = emojified?.replace("t", emojis[19])
        emojified = emojified?.replace("u", emojis[20])
        emojified = emojified?.replace("v", emojis[21])
        emojified = emojified?.replace("w", emojis[22])
        emojified = emojified?.replace("x", emojis[23])
        emojified = emojified?.replace("y", emojis[24])
        emojified = emojified?.replace("z", emojis[25])

        /* Substitute A - Z Base64 characters with emojis. */
        emojified = emojified?.replace("A", emojis[26])
        emojified = emojified?.replace("B", emojis[27])
        emojified = emojified?.replace("C", emojis[28])
        emojified = emojified?.replace("D", emojis[29])
        emojified = emojified?.replace("E", emojis[30])
        emojified = emojified?.replace("F", emojis[31])
        emojified = emojified?.replace("G", emojis[32])
        emojified = emojified?.replace("H", emojis[33])
        emojified = emojified?.replace("I", emojis[34])
        emojified = emojified?.replace("J", emojis[35])
        emojified = emojified?.replace("K", emojis[36])
        emojified = emojified?.replace("L", emojis[37])
        emojified = emojified?.replace("M", emojis[38])
        emojified = emojified?.replace("N", emojis[39])
        emojified = emojified?.replace("O", emojis[40])
        emojified = emojified?.replace("P", emojis[41])
        emojified = emojified?.replace("Q", emojis[42])
        emojified = emojified?.replace("R", emojis[43])
        emojified = emojified?.replace("S", emojis[44])
        emojified = emojified?.replace("T", emojis[45])
        emojified = emojified?.replace("U", emojis[46])
        emojified = emojified?.replace("V", emojis[47])
        emojified = emojified?.replace("W", emojis[48])
        emojified = emojified?.replace("X", emojis[49])
        emojified = emojified?.replace("Y", emojis[50])
        emojified = emojified?.replace("Z", emojis[51])

        /* Substitute 0 - 9 Base64 characters with emojis. */
        emojified = emojified?.replace("0", emojis[52])
        emojified = emojified?.replace("1", emojis[53])
        emojified = emojified?.replace("2", emojis[54])
        emojified = emojified?.replace("3", emojis[55])
        emojified = emojified?.replace("4", emojis[56])
        emojified = emojified?.replace("5", emojis[57])
        emojified = emojified?.replace("6", emojis[58])
        emojified = emojified?.replace("7", emojis[59])
        emojified = emojified?.replace("8", emojis[60])
        emojified = emojified?.replace("9", emojis[61])

        /* Substitute +, /, and = Base64 characters with emojis. */
        emojified = emojified?.replace("+", emojis[62])
        emojified = emojified?.replace("/", emojis[63])
        emojified = emojified?.replace("=", emojis[64])

        txtEncrypted.text = emojified
    }

    fun unemojify(decod: String?) {
        /* Substitute a - z Base64 characters with emojis. */
        var unemojified = decod?.replace(emojis[0], "a")
        unemojified = unemojified?.replace(emojis[1], "b")
        unemojified = unemojified?.replace(emojis[2], "c")
        unemojified = unemojified?.replace(emojis[3], "d")
        unemojified = unemojified?.replace(emojis[4], "e")
        unemojified = unemojified?.replace(emojis[5], "f")
        unemojified = unemojified?.replace(emojis[6], "g")
        unemojified = unemojified?.replace(emojis[7], "h")
        unemojified = unemojified?.replace(emojis[8], "i")
        unemojified = unemojified?.replace(emojis[9], "j")
        unemojified = unemojified?.replace(emojis[10], "k")
        unemojified = unemojified?.replace(emojis[11], "l")
        unemojified = unemojified?.replace(emojis[12], "m")
        unemojified = unemojified?.replace(emojis[13], "n")
        unemojified = unemojified?.replace(emojis[14], "o")
        unemojified = unemojified?.replace(emojis[15], "p")
        unemojified = unemojified?.replace(emojis[16], "q")
        unemojified = unemojified?.replace(emojis[17], "r")
        unemojified = unemojified?.replace(emojis[18], "s")
        unemojified = unemojified?.replace(emojis[19], "t")
        unemojified = unemojified?.replace(emojis[20], "u")
        unemojified = unemojified?.replace(emojis[21], "v")
        unemojified = unemojified?.replace(emojis[22], "w")
        unemojified = unemojified?.replace(emojis[23], "x")
        unemojified = unemojified?.replace(emojis[24], "y")
        unemojified = unemojified?.replace(emojis[25], "z")

        /* Substitute A - Z Base64 characters with emojis. */
        unemojified = unemojified?.replace(emojis[26], "A")
        unemojified = unemojified?.replace(emojis[27], "B")
        unemojified = unemojified?.replace(emojis[28], "C")
        unemojified = unemojified?.replace(emojis[29], "D")
        unemojified = unemojified?.replace(emojis[30], "E")
        unemojified = unemojified?.replace(emojis[31], "F")
        unemojified = unemojified?.replace(emojis[32], "G")
        unemojified = unemojified?.replace(emojis[33], "H")
        unemojified = unemojified?.replace(emojis[34], "I")
        unemojified = unemojified?.replace(emojis[35], "J")
        unemojified = unemojified?.replace(emojis[36], "K")
        unemojified = unemojified?.replace(emojis[37], "L")
        unemojified = unemojified?.replace(emojis[38], "M")
        unemojified = unemojified?.replace(emojis[39], "N")
        unemojified = unemojified?.replace(emojis[40], "O")
        unemojified = unemojified?.replace(emojis[41], "P")
        unemojified = unemojified?.replace(emojis[42], "Q")
        unemojified = unemojified?.replace(emojis[43], "R")
        unemojified = unemojified?.replace(emojis[44], "S")
        unemojified = unemojified?.replace(emojis[45], "T")
        unemojified = unemojified?.replace(emojis[46], "U")
        unemojified = unemojified?.replace(emojis[47], "V")
        unemojified = unemojified?.replace(emojis[48], "W")
        unemojified = unemojified?.replace(emojis[49], "X")
        unemojified = unemojified?.replace(emojis[50], "Y")
        unemojified = unemojified?.replace(emojis[51], "Z")

        /* Substitute 0 - 9 Base64 characters with emojis. */
        unemojified = unemojified?.replace(emojis[52], "0")
        unemojified = unemojified?.replace(emojis[53], "1")
        unemojified = unemojified?.replace(emojis[54], "2")
        unemojified = unemojified?.replace(emojis[55], "3")
        unemojified = unemojified?.replace(emojis[56], "4")
        unemojified = unemojified?.replace(emojis[57], "5")
        unemojified = unemojified?.replace(emojis[58], "6")
        unemojified = unemojified?.replace(emojis[59], "7")
        unemojified = unemojified?.replace(emojis[60], "8")
        unemojified = unemojified?.replace(emojis[61], "9")

        /* Substitute +, /, and = Base64 characters with emojis. */
        unemojified = unemojified?.replace(emojis[62], "+")
        unemojified = unemojified?.replace(emojis[63], "/")
        unemojified = unemojified?.replace(emojis[64], "=")

        val actualByte: ByteArray = Base64.getDecoder().decode(unemojified)
        val actualString = String(actualByte)
        txtDecrypted.text = actualString
    }

}