package jp.tomiyama.noir.toolbarsample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Toolbarを取得
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    // ツールバーにロゴを設定
    toolbar.setLogo(R.mipmap.ic_launcher)
    // ツールバーにタイトル文字列を設定
    toolbar.setTitle(R.string.toolbar_title)
    // ツールバーのタイトル文字列を設定
    toolbar.setTitleTextColor(Color.WHITE)
    // ツールバーのサブタイトル文字列を設定
    toolbar.setSubtitle(R.string.toolbar_subtitle)
    // ツールバーのサブタイトル文字色を設定
    toolbar.setSubtitleTextColor(Color.LTGRAY)
    // アクションバーにツールバーを設定
    setSupportActionBar(toolbar)
  }
}
