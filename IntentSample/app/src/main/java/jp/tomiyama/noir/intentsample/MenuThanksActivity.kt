package jp.tomiyama.noir.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MenuThanksActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_thanks)

    // リスト画面から渡されたデータを取得
    val menuName = intent.getStringExtra("menuName")
    val menuPrice = intent.getStringExtra("menuPrice")

    // 定食名と金額を表示させるTextViewを取得
    val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
    val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

    // TextViewに定食名と金額を表示
    tvMenuName.text = menuName
    tvMenuPrice.text = menuPrice
  }

  // 戻るボタンをタップした時の処理
  fun onBackButtonClick(view: View){
    finish()
  }
}
